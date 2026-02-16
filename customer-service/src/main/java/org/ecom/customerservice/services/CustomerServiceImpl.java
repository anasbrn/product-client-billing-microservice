package org.ecom.customerservice.services;

import lombok.AllArgsConstructor;
import org.ecom.customerservice.dtos.CustomerDto;
import org.ecom.customerservice.entities.Customer;
import org.ecom.customerservice.mappers.CustomerMapper;
import org.ecom.customerservice.repositories.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepo.findAll();
        return customers.stream().map(customerMapper::toDto).toList();
    }
}
