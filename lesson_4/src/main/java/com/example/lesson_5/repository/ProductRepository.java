package com.example.lesson_5.repository;

import com.example.lesson_5.exception.ServiceException;
import com.example.lesson_5.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {
    private List<Product> productList = new CopyOnWriteArrayList<>();
    private AtomicLong generator = new AtomicLong();

    @PostConstruct
    public void init() {
        productList.add(new Product(generator.getAndIncrement(), "Bread", 50, 1, false));
        productList.add(new Product(generator.getAndIncrement(), "Meet", 460, 1, false));
        productList.add(new Product(generator.getAndIncrement(), "Beer", 65, 1, false));
        productList.add(new Product(generator.getAndIncrement(), "Lemonade", 70, 1, false));
        productList.add(new Product(generator.getAndIncrement(), "Tomato", 270, 1, false));
        productList.add(new Product(generator.getAndIncrement(), "Carrot", 15, 1, false));
        productList.add(new Product(generator.getAndIncrement(), "Potato", 45, 1, false));
    }

    public List<Product> findAll() {
        return productList.stream()
                .filter(i -> !i.getIsDeleted()).collect(Collectors.toUnmodifiableList());
    }

    public Product create(Product product) {
        product.setId(generator.getAndIncrement());
        productList.add(product);
        return product;
    }

    public Product update(Product product) {
        if (product.getId() == null) {
            throw new ServiceException("can't update");
        }
        Product productInDB = productList.stream()
                .filter(pr -> pr.getId().equals(product.getId()))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
        product.setVersion(productInDB.getVersion() + 1);
        product.setIsDeleted(false);
        productList.remove(productInDB);
        productList.add(product);
        return product;
    }

    public int deleteById(Long id) {
        List<Product> toDelete = productList.stream()
                .filter(pr -> pr.getId().equals(id))
                .collect(Collectors.toList());
        toDelete.forEach(pr->pr.setIsDeleted(true));
        return toDelete.size();
    }
}
