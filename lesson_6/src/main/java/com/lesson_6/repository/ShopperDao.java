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
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Setter
public class ShopperDao {
    private final SessionFactory factory;

    public List<Shopper> findAll() {
        return HibernateUtil.doInTransaction(factory, session ->
                session.createQuery("select p from Shopper p", Shopper.class).getResultList());
    }

    public Shopper findById(Long id) {
        return HibernateUtil.doInTransaction(factory, session -> session.get(Shopper.class, id));
    }

    public void deleteById(Long id) {
        HibernateUtil.doInTransaction(factory, session -> {
            Shopper shopper = session.get(Shopper.class, id);
            session.delete(shopper);
            return null;
        });
    }

    public Shopper saveOrUpdate(Shopper shopper) {
        return (Shopper) HibernateUtil.doInTransaction(factory, session -> session.merge(shopper));
    }

}
