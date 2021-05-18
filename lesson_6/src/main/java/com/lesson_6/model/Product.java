package com.lesson_6.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "cost")
    int cost;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_shoppers",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "shopper_id")
    )
    List<Shopper> shoppers;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    List<PurchaseHistory> purchaseHistoryList;



}
