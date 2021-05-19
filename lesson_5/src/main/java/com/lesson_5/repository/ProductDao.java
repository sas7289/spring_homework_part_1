package com.lesson_5.repository;


import com.lesson_5.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {
    private static SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .buildSessionFactory();

    public static List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                List<Product> res = session.createQuery("select p from Product p", Product.class).getResultList();
                session.getTransaction().commit();
                return res;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public static Product findById(Long id) {
        try (Session session = factory.getCurrentSession();) {
            try {
                session.beginTransaction();
                Product product = session.get(Product.class, id);
                session.getTransaction().commit();
                return product;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

    public static void deleteById(Long id) {
        try (Session session = factory.getCurrentSession();) {
            try {
                session.beginTransaction();
                Product product = session.get(Product.class, id);
                session.delete(product);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
            }
        }
    }

    public static Product saveOrUpdate(Product product) {
        try (Session session = factory.openSession()) {
            try {
                session.beginTransaction();
                session.merge(product);
                session.getTransaction().commit();
                return product;
            } catch (Exception e) {
                session.getTransaction().rollback();
                return null;
            }
        }
    }

}
