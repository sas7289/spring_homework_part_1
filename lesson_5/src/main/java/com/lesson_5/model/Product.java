package com.lesson_5.model;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    public Product() {
    }

    @Column(name = "title")
    String title;

    @Column(name = "price")
    int price;
}
