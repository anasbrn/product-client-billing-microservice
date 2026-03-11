package org.ecom.productservice.services;

import lombok.AllArgsConstructor;
import org.ecom.productservice.dtos.request.ProductDto;
import org.ecom.productservice.entities.Product;
import org.ecom.productservice.mappers.ProductMapper;
import org.ecom.productservice.repositories.ProductRepo;
import org.ecom.productservice.requests.ProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private ProductMapper productMapper;
    private FileStorageService fileStorageService;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::toDto).toList();
    }

    public Product create(ProductRequest request) {
        String imgPath = fileStorageService.upload(request.getImage(), "products/");
        Product product = productMapper.toEntity(request);
        product.setImgPath(imgPath);

        return productRepo.save(product);
    }
}
