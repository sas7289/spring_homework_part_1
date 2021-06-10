package com.example.lesson_8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long productId;

    private Integer productPrice;

    private Integer quantity;

    public OrderItem(Long productId, String title, Integer productPrice, Integer quantity) {
        this.productId = productId;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.title = title;
    }
}
