package com.bandhan.order.controller;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/process")
    public void createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        orderService.processOrder(createOrderRequest);
    }
}
