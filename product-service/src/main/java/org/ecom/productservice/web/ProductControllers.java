package org.ecom.productservice.web;

import lombok.AllArgsConstructor;
import org.ecom.productservice.dtos.ProductDto;
import org.ecom.productservice.services.ProductServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/products")
public class ProductControllers {
    private ProductServiceImpl productServiceImpl;

    @GetMapping("")
    public List<ProductDto> getAll() {
        return this.productServiceImpl.getAll();
    }
}
