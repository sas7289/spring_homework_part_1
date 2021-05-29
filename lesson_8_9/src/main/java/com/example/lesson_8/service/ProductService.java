package com.example.lesson_8.service;

import com.example.lesson_8.model.Product;
import com.example.lesson_8.repository.ProductRepository;
import com.example.lesson_8.service.specifications.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Page<Product> findAll(Map<String, String> params , Integer pageNumber, Integer pageSize) {
        final Specification<Product> productSpecification = ProductSpecification.productSpecificationByParams(params);
        return repository.findAll(productSpecification, PageRequest.of(pageNumber - 1, pageSize));
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

//    public void delete(Product product) {
//            repository.delete(product);
//    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
