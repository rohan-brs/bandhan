package com.bandhan.order.controller;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/process")
    public ResponseEntity<?> createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) throws Exception {
        orderService.processOrder(createOrderRequest);
        return ResponseEntity.ok("Order processed");
    }
}
