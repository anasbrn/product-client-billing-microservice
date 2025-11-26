package org.ecom.customerservice;

import org.ecom.customerservice.config.CustomerConfigParams;
import org.ecom.customerservice.entities.Customer;
import org.ecom.customerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepo customerRepo) {
        return args -> {
            customerRepo.save(Customer
                    .builder()
                    .firstName("Anas")
                    .lastName("Brn")
                    .email("anasbrn@gmail.com")
                    .build());

            customerRepo.save(Customer
                    .builder()
                    .firstName("Ahmed")
                    .lastName("Ahmed")
                    .email("ahmed@gmail.com")
                    .build());
        };
    }

}
