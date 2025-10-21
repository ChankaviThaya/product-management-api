package com.example.product_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId; // primary key for product record

    @Column(nullable = false)
    private String productName; // e.g., Laptop, Phone, Headphones

    @Column(nullable = false)
    private String category; // e.g., Electronics, Clothing, Grocery

    @Column(nullable = false)
    private Double price; // price of the product

    @Column(nullable = false)
    private Integer quantity; // available stock quantity
}
