package com.bandhan.order.entity;

import com.bandhan.order.constant.ItemType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private ItemType itemType;

    @Column(name = "inventory_balance")
    private int inventoryBalance;

    @Column(name = "price_per_unit")
    private double pricePerUnit;
}
