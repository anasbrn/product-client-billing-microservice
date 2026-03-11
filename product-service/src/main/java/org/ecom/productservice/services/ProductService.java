package org.ecom.productservice.services;

import org.ecom.productservice.dtos.request.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAll();
}
