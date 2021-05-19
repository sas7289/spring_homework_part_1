package com.lesson_6.util;

import org.hibernate.Session;

@FunctionalInterface
public interface HibernateAction<T> {
    T perform(Session session);
}
