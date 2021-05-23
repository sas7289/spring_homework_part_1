package com.example.lesson_8.service;

import com.example.lesson_8.model.Product;
import com.example.lesson_8.repository.ProductRepository;
import com.example.lesson_8.service.specifications.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public Page<Product> findAll(Map<String, String> params, Pageable pages) {
        final Specification<Product> productSpecification = params.entrySet().stream()
                .filter(p -> StringUtils.hasText(p.getValue()))
                .map(p -> {
                    switch (p.getKey()) {
                        case "title":
                            return ProductSpecification.nameEquals(p.getValue());
                        case "cost":
                            return ProductSpecification.costEquals(Integer.parseInt(p.getValue()));
                        default:
                            return null;
                    }
                })
                .filter(Objects::nonNull)
                .reduce((p1, p2) -> p1.and(p2))
                .orElse(null);
        return repository.findAll(productSpecification, pages);
    }

    public void saveProduct(Product product) {
        repository.save(product);
    }

    public void delete(Product product) {
            repository.delete(product);
    }
}
