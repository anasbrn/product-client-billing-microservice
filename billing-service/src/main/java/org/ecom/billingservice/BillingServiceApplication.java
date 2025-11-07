package org.ecom.billingservice;

import org.ecom.billingservice.entities.Bill;
import org.ecom.billingservice.entities.ProductItem;
import org.ecom.billingservice.repositories.BillingRepository;
import org.ecom.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            BillingRepository billingRepository,
            ProductItemRepository productItemRepository
    ) {
        return args -> {
            List<Long> customerIds = List.of(1L, 2L);
            List<Long> productIds = List.of(1L, 2L);

            customerIds.forEach(customerId -> {
                Bill bill = Bill
                        .builder()
                        .customerId(customerId)
                        .date(new Date())
                        .build();
                billingRepository.save(bill);

                productIds.forEach(productId -> {
                    ProductItem productItem = ProductItem
                            .builder()
                            .price(Math.random() * 1000)
                            .quantity(20 * new Random().nextInt(10))
                            .productId(productId)
                            .bill(bill)
                            .build();
                    productItemRepository.save(productItem);
                });
            });
        };
    }
}
