package org.ecom.productservice.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.ecom.productservice.dtos.request.ProductDto;
import org.ecom.productservice.dtos.response.ApiResponse;
import org.ecom.productservice.entities.Product;
import org.ecom.productservice.requests.ProductRequest;
import org.ecom.productservice.services.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Product>> store(@Valid @ModelAttribute ProductRequest request) {
        Product product = this.productServiceImpl.create(request);

        return ResponseEntity
                .created(URI.create("/api/products/" + product.getId()))
                .body(
                        new ApiResponse<>("Product created successfully", product)
                );
    }
}
