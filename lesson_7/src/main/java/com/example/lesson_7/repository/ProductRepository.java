package com.example.lesson_7.repository;

import com.example.lesson_7.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select min(p.cost) from Product p")
    int findMin();

    @Query("select max(p.cost) from Product p")
    int findMax();

    List<Product> findProductByCostGreaterThan(int minCost);

    List<Product> findProductByCostLessThan(int maxCost);

    List<Product> findProductByCostGreaterThanAndCostLessThan(int minCost, int maxCost);
}
