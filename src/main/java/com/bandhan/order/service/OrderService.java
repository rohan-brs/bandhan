package com.bandhan.order.service;

import com.bandhan.order.dto.CreateOrderRequest;import org.springframework.stereotype.Service;

public interface OrderService {

    void createOrder(CreateOrderRequest createOrderRequest);
}
