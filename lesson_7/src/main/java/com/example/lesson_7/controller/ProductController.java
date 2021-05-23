package com.example.lesson_7.controller;

import com.example.lesson_7.model.Product;
import com.example.lesson_7.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
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
    @PostMapping("save")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("delete/{id}")
    public void deleteProduct(@PathVariable(name = "id") Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/greater")
    public List<Product> findGreaterThenMin() {
        return productRepository.findProductByCostGreaterThan(productRepository.findMin());
    }

    @GetMapping("/less")
    public List<Product> findLessThenMax() {
        return productRepository.findProductByCostLessThan(productRepository.findMax());
    }

    @GetMapping("/between")
    public List<Product> findBetweenMinAndMax() {
        int min = productRepository.findMin();
        int max = productRepository.findMax();
        return productRepository.findProductByCostGreaterThanAndCostLessThan(min, max);
    }
}
