package com.example.lesson_8.service.specifications;

import com.example.lesson_8.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductSpecification {
    public static Specification<Product> nameEquals(String title) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Product> costEquals(Integer cost) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("cost"), cost);
    }

    public static Specification<Product> productSpecificationByParams(Map<String, String> params) {
        return params.entrySet().stream()
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
    }
}
