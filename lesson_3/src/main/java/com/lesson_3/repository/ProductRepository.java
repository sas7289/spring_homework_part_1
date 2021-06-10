package com.lesson_3.repository;

import com.lesson_3.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ProductRepository {
    private static final List<Product> products;
    static {
        products = new CopyOnWriteArrayList<>();
        products.add(new Product("Bread", 50));
        products.add(new Product("Beer", 70));
        products.add(new Product("Lemonade", 45));
    }
    public Product getProduct(long id) {
        if(id < 0) {
            throw new IllegalArgumentException();
        }
        for (Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public void add(Product product) {
        products.add(product);
    }
}
