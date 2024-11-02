package com.bandhan.order.service;

import com.bandhan.order.dto.CreateOrderRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {

    void processOrder(CreateOrderRequest createOrderRequest) throws Exception;

    void createOrder(CreateOrderRequest createOrderRequest);
}
