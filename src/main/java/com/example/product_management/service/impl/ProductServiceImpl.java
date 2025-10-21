package com.example.product_management.service.impl;

import com.example.product_management.dto.ProductDTO;
import com.example.product_management.model.Product;
import com.example.product_management.repository.ProductRepository;
import com.example.product_management.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    // Add a new product using ProductDTO
    @Override
    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductName(productDTO.getProductName());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        return repo.save(product);
    }

    // Retrieve all products
    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // Retrieve products by category
    @Override
    public List<Product> getProductsByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }

    // Search product by name
    @Override
    public Optional<Product> getProductByName(String productName) {
        return repo.findByProductNameIgnoreCase(productName);
    }

    // Delete product by name
    @Override
    public void deleteProductByName(String productName) {
        Optional<Product> productOpt = repo.findByProductNameIgnoreCase(productName);
        productOpt.ifPresent(repo::delete);
    }
}
