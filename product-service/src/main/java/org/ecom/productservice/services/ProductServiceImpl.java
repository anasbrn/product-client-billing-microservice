package org.ecom.productservice.services;

import lombok.AllArgsConstructor;
import org.ecom.productservice.dtos.ProductDto;
import org.ecom.productservice.entities.Product;
import org.ecom.productservice.mappers.ProductMapper;
import org.ecom.productservice.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private ProductMapper productMapper;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::toDto).toList();
    }
}
