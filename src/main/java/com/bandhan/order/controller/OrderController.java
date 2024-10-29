package com.bandhan.order.controller;

import com.bandhan.order.dto.CreateOrderRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @PostMapping("/process")
    public void createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {

    }
}
