package com.example.practice.controller;

import com.example.practice.domain.Product;
import com.example.practice.repo.ProductRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepo repository;

    public ProductController(ProductRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/products")
    List<Product> allProducts(){
        return repository.findAll();
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product product){
        return repository.save(product);
    }

    @GetMapping("/products/{id}")
    Product oneProduct(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @PutMapping("product/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id){
        return repository.findById(id).map(product -> {
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repository.save(product);
        }).orElseGet(() ->{
           newProduct.setId(id);
           return repository.save(newProduct);
        });
    }

    @DeleteMapping("products/{id}")
    void deleteProduct(@PathVariable Long id){
        repository.deleteById(id);
    }
}
