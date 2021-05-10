package com.lesson_6.config;

import com.lesson_6.model.Product;
import com.lesson_6.model.Shopper;
import lombok.Data;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
//@AllArgsConstructor
//@NoArgsConstructor
@Data
public class HiberSession {

    @Bean
    public Configuration config() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Shopper.class);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return config().buildSessionFactory();
    }
}
