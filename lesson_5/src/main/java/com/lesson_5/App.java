package com.lesson_5;

import com.lesson_5.model.Product;
import com.lesson_5.repository.ProductDao;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Product product = new Product(10L, "Shark", 65);
        ProductDao.saveOrUpdate(product);
        ProductDao.deleteById(2L);
        Product productTwo = ProductDao.findById(2L);
        List<Product> products = ProductDao.findAll();
    }
}
