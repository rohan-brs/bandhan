package com.bandhan.order.delegate;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.OrderDetails;
import com.bandhan.order.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class CreateOrder implements JavaDelegate {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        // TODO:: Look for a better way to fetch the json req
        String orderJson = delegateExecution.getBusinessKey();
        CreateOrderRequest createOrderRequest = objectMapper.readValue(orderJson, CreateOrderRequest.class);
        OrderDetails order = orderService.createOrder(createOrderRequest);
        delegateExecution.setVariable("orderId", order.getId());
        delegateExecution.setVariable("customerType", order.getId());
    }
}
