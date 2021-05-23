package com.example.lesson_8.service.specifications;

import com.example.lesson_8.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {
    public static Specification<Product> nameEquals(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Product> costEquals(Integer cost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cost"), cost);
    }
}
