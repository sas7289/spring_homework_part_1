package com.lesson_3.service;

import com.lesson_3.dto.Product;
import com.lesson_3.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(long id) {
        return productRepository.getProduct(id);
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productRepository.findAll());
    }

    public void add(Product product) {
        productRepository.add(product);
    }
}
