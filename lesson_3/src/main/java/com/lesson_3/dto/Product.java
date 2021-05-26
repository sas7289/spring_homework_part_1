package com.lesson_3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Product {
    private static long count = 0;

    private long id;
    private String title;
    private int cost;

    public Product(String title, int cost) {
        this.id = count++;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
        this.id = count++;
    }
}
