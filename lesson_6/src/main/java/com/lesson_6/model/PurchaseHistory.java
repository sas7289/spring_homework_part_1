package com.lesson_6.model;

import com.lesson_6.model.Product;
import com.lesson_6.model.Shopper;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "shopper_id")
    Shopper shopper;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;

    @Column(name = "cost")
    Long cost;
}
