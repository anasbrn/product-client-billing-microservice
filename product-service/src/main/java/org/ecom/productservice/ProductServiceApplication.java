package org.ecom.productservice;

import org.ecom.productservice.entities.Product;
import org.ecom.productservice.repositories.ProductRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepo productRepo) {
        return args -> {
            productRepo.save(
                    Product
                            .builder()
                            .name("Laptop")
                            .price(15000.0)
                            .description("This is a description for laptop product")
                            .build()
            );

            productRepo.save(
                    Product
                            .builder()
                            .name("Camera")
                            .price(6000.0)
                            .description("This is a description for camera product")
                            .build()
            );
        };
    }
}
