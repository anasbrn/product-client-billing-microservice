package org.ecom.productservice.mappers;

import org.ecom.productservice.dtos.ProductDto;
import org.ecom.productservice.entities.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);
}
