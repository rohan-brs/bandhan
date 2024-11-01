package com.bandhan.order.entity;

import com.bandhan.order.constant.ShipmentType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_quantity")
    private int itemQuantity;

    @Column(name = "order_price")
    private double orderPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipment_type")
    private ShipmentType shipmentType;
}
