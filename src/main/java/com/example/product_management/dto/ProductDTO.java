package com.example.product_management.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @NotBlank(message = "Product name is mandatory")
    private String productName;

    @NotBlank(message = "Category is mandatory")
    private String category;

    @Min(value = 1, message = "Price must be at least 1")
    private Double price;

    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
}
