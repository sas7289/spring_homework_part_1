package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/products")
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("{id}")
    public Product findById(@PathVariable(name = "id") Long id) {
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @GetMapping
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //Протестировать с помощью постмана
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productRepository.deleteById(id);
    }
}
