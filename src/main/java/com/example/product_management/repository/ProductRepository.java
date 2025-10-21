package com.example.product_management.repository;

import com.example.product_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // 1. Find all products by category (case-insensitive)
    List<Product> findByCategoryIgnoreCase(String category);

    // 2. Find product by name (case-insensitive)
    Optional<Product> findByProductNameIgnoreCase(String productName);
}
