package org.ecom.productservice.mappers;

import org.ecom.productservice.dtos.request.ProductDto;
import org.ecom.productservice.entities.Product;
import org.ecom.productservice.requests.ProductRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);

    @Mapping(target = "imgPath", ignore = true)
    Product toEntity(ProductRequest request);
}
