package com.bandhan.order.service;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.OrderDetails;
import javassist.NotFoundException;

public interface OrderService {

    void processOrder(CreateOrderRequest createOrderRequest) throws Exception;

    OrderDetails createOrder(CreateOrderRequest createOrderRequest);

    void updateOrder(int orderId, String shipmentType) throws NotFoundException;
}
