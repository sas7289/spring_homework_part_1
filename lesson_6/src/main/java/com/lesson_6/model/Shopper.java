package com.lesson_6.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shoppers")
@NoArgsConstructor
public class Shopper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_shoppers",
            joinColumns = @JoinColumn(name = "shopper_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> products;

    @OneToMany(mappedBy = "shopper", fetch = FetchType.EAGER)
    List<PurchaseHistory> purchaseHistoryList;
}
