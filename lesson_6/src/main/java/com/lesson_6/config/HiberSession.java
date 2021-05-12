package com.lesson_6.config;

import com.lesson_6.model.Product;
import com.lesson_6.model.Shopper;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class HiberSession {

    @Bean
    public org.hibernate.cfg.Configuration config() {
        return new Configuration()
                .configure("hibernate.cfg.xml");
    }

    @Bean
    public SessionFactory sessionFactory() {
        SessionFactory factory = config().buildSessionFactory();
        return factory;
    }
}
