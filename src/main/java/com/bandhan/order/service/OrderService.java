package com.bandhan.order.service;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.OrderDetails;

public interface OrderService {

    void processOrder(CreateOrderRequest createOrderRequest) throws Exception;

    OrderDetails createOrder(CreateOrderRequest createOrderRequest);
}
