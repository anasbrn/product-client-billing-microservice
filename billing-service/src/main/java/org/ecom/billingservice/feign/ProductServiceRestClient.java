package org.ecom.billingservice.feign;

import org.ecom.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("prodcut-service")
public interface ProductServiceRestClient {
    @GetMapping("/products/{id}")
    Product findByProductId(@PathVariable Long id);
} 
