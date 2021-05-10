package com.lesson_6.repository;

import com.lesson_6.model.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class ProductDao {
    SessionFactory factory;


    public List<Product> findAll() {
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

    public Product findById(Long id) {
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

    public void deleteById(Long id) {
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

    public Product saveOrUpdate(Product product) {
        HibernateUtil.doInTransaction(factory, session -> {
            session.merge(product);
        })
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
