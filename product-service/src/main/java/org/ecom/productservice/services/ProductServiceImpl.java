package org.ecom.productservice.services;

import lombok.AllArgsConstructor;
import org.ecom.productservice.dtos.request.ProductDto;
import org.ecom.productservice.entities.Product;
import org.ecom.productservice.mappers.ProductMapper;
import org.ecom.productservice.repositories.ProductRepo;
import org.ecom.productservice.requests.ProductRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private ProductMapper productMapper;
    private S3Service s3Service;

    @Override
    public List<ProductDto> getAll() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(productMapper::toDto).toList();
    }

    public Product create(ProductRequest request) throws IOException {
        String imgPath = s3Service.upload(request.getImage(), "products");
        Product product = productMapper.toEntity(request);
        product.setImgPath(imgPath);

        return productRepo.save(product);
    }
}
