package com.bandhan.order.entity;

import com.bandhan.order.constant.ItemType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private ItemType type;

    @Column(name = "price_per_unit")
    private String pricePerUnit;
}
