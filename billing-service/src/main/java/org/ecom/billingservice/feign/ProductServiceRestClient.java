package org.ecom.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.ecom.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product-service")
public interface ProductServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "product-service", fallbackMethod = "getDefaultProduct")
    Product findByProductId(@PathVariable Long id);

    default Product getDefaultProduct(Long id, Exception exception){
        return new Product();
    }
} 
