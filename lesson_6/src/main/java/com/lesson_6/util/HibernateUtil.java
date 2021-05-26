package com.lesson_6.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateUtil<T> {
    public static <T> T doInTransaction(SessionFactory factory, HibernateAction<T> action) {
        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                final T result = action.perform(session);
                session.getTransaction().commit();
                return result;
            } catch (Exception exception) {
                session.getTransaction().rollback();
                throw exception;
            }
        }
    }
}
