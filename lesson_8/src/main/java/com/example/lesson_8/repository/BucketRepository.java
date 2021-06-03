package com.example.lesson_8.repository;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
@Setter
public class BucketRepository {
    private final SessionFactory factory;

    @Query(value = "insert into users_products (user_id, product_id) values (:user_id, :product_id)", nativeQuery = true)
    public void saveProductsToBucket(Long user_id, Long product_id) {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                session.createNativeQuery("insert into users_products (user_id, product_id) values (:user_id, :product_id)");
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}