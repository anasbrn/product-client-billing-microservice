package org.ecom.customerservice;

import org.ecom.customerservice.entities.Customer;
import org.ecom.customerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
