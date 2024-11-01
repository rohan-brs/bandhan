package com.bandhan.order.service.impl;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void createOrder(CreateOrderRequest createOrderRequest) {
        log.info("Started creating order for req: {}", createOrderRequest);
        try {
            String json = objectMapper.writeValueAsString(createOrderRequest);
            ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("processOrder", json);
            log.info("Started process : {}", processInstance.getId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
