package org.ecom.customerservice.mappers;

import org.ecom.customerservice.dtos.CustomerDto;
import org.ecom.customerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto customerDto);
}
