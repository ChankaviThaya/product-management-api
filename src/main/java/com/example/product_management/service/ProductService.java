package com.example.product_management.service;

import com.example.product_management.dto.ProductDTO;
import com.example.product_management.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Add a new product using ProductDTO
    Product addProduct(ProductDTO productDTO);

    // Retrieve all products
    List<Product> getAllProducts();

    // Retrieve products by category
    List<Product> getProductsByCategory(String category);

    // Search product by name
    Optional<Product> getProductByName(String productName);

    // Delete product by name
    void deleteProductByName(String productName);
}
