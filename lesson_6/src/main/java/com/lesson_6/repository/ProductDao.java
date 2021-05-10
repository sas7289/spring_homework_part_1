package com.lesson_6.repository;

import com.lesson_6.model.Product;
import com.lesson_6.model.Shopper;
import com.lesson_6.util.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Setter
public class ProductDao {
    private final SessionFactory factory;


    public List<Product> findAll() {
        return HibernateUtil.doInTransaction(factory, session ->
                session.createQuery("select p from Product p", Product.class).getResultList());
    }

    public Product findById(Long id) {
        return HibernateUtil.doInTransaction(factory, session -> session.get(Product.class, id));
    }

    public void deleteById(Long id) {
        HibernateUtil.doInTransaction(factory, session -> {
            Product product = session.get(Product.class, id);
            session.delete(product);
            return null;
        });
    }

    public Product saveOrUpdate(Product product) {
        return (Product) HibernateUtil.doInTransaction(factory, session -> session.merge(product));
    }

    public List<Shopper> getShoppersByProductId(Long id) {
        return HibernateUtil.doInTransaction(factory, session -> session.createQuery("select s from Shopper s").getResultList());
    }
}
