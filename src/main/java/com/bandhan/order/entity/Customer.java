package com.bandhan.order.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "username")
    public String username;

    @Column(name = "email")
    public String email;

    @Column(name = "mobile")
    public String mobile;

    @Column(name = "password")
    public String password;
}
