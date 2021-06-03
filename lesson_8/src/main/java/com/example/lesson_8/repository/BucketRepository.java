package com.example.lesson_8.repository;

import com.example.lesson_8.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface BucketRepository extends JpaRepository<Product, Long> {

    @Modifying
    @Query(value = "insert into users_products (product_id, user_id) values (:product_id, :user_id)", nativeQuery = true)
    public void saveProductsToBucket(@Param("product_id") Long productId, @Param("user_id") Long userId);
}