package org.ecom.customerservice.services;

import org.ecom.customerservice.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAll();
}
