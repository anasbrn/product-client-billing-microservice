package org.ecom.productservice.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    @Positive
    private Double price;
    @NotNull
    private MultipartFile image;
}
