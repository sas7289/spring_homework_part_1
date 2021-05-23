package com.example.lesson_8.repository;

import com.example.lesson_8.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long>, JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
