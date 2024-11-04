package com.bandhan.order.entity;

import com.bandhan.order.constant.ShipmentType;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Inventory item;

    @Column(name = "item_quantity")
    private int itemQuantity;

    @Column(name = "order_price")
    private double orderPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "shipment_type")
    private ShipmentType shipmentType;

    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updatedDate;
}
