package com.lesson_6;

import com.lesson_6.config.JavaConfig;
import com.lesson_6.model.Product;
import com.lesson_6.model.Shopper;
import com.lesson_6.repository.ProductDao;
import com.lesson_6.repository.ShopperDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        Product product = productDao.findById(2L);
        ShopperDao shopperDao = context.getBean(ShopperDao.class);
        Shopper shopper = shopperDao.findById(1L);
    }
}