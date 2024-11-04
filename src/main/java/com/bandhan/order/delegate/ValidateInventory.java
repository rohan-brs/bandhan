package com.bandhan.order.delegate;

import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

@Named
public class ValidateInventory implements JavaDelegate {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String orderJson = delegateExecution.getBusinessKey();
        CreateOrderRequest createOrderRequest = objectMapper.readValue(orderJson, CreateOrderRequest.class);
        boolean isValidInventory = inventoryService.isValidInventory(createOrderRequest);
        delegateExecution.setVariable("isValidInventory", isValidInventory);
    }
}
