package org.ecom.customerservice.web;

import lombok.AllArgsConstructor;
import org.ecom.customerservice.dtos.CustomerDto;
import org.ecom.customerservice.services.CustomerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerControllers {
    private final CustomerServiceImpl customerServiceImpl;

    @GetMapping("")
    public List<CustomerDto> getAll() {
        return customerServiceImpl.getAll();
    }
}
