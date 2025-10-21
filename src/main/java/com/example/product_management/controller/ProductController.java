package com.example.product_management.controller;

import com.example.product_management.dto.ProductDTO;
import com.example.product_management.model.Product;
import com.example.product_management.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // POST /api/products → Add new product with validation
    @PostMapping
    public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDTO productDTO) {
        Product savedProduct = productService.addProduct(productDTO);
        return ResponseEntity.ok(savedProduct);
    }

    // GET /api/products → Retrieve all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // GET /api/products/category/{category} → Retrieve products by category
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    // GET /api/products/{name} → Search product by name
    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        Optional<Product> productOpt = productService.getProductByName(name);
        return productOpt.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE /api/products/{name} → Delete product by name
@DeleteMapping("/{name}")
public ResponseEntity<String> deleteProductByName(@PathVariable String name) {
    Optional<Product> productOpt = productService.getProductByName(name);
    if (productOpt.isPresent()) {
        productService.deleteProductByName(name);
        return ResponseEntity.ok("Product deleted successfully");
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
