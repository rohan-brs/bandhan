package com.bandhan.order.service.impl;

import com.bandhan.order.constant.OrderConstants;
import com.bandhan.order.dto.CreateOrderRequest;
import com.bandhan.order.entity.Customer;
import com.bandhan.order.entity.Inventory;
import com.bandhan.order.entity.OrderDetails;
import com.bandhan.order.repository.OrderRepo;
import com.bandhan.order.service.CustomerService;
import com.bandhan.order.service.InventoryService;
import com.bandhan.order.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void processOrder(CreateOrderRequest createOrderRequest) throws Exception {
        log.info("Started creating order for req: {}", createOrderRequest);
        try {
            String json = objectMapper.writeValueAsString(createOrderRequest);
            log.info("Starting process : {}", OrderConstants.PROCESS_ORDER);
            runtimeService.startProcessInstanceByKey(OrderConstants.PROCESS_ORDER, json);
        } catch (Exception e) {
            log.error("Error starting process: {}", OrderConstants.PROCESS_ORDER, e);
            throw e;
        }
    }

    @Override
    public OrderDetails createOrder(CreateOrderRequest createOrderRequest) {
        try {
            Customer customer = customerService.getCustomer(createOrderRequest.getCustomer().getUsername());
            Inventory item = inventoryService.updateAndGetInventory(createOrderRequest.getItemId(), createOrderRequest.getNoOfItem());
            OrderDetails orderDetails = createNewOrder(customer, createOrderRequest, item);
            orderDetails = orderRepo.save(orderDetails);
            return orderDetails;
        } catch (NotFoundException e) {
            // This should not happen as this will be validated in initial stages
            log.error(e.getMessage());
        }
        return null;
    }

    private OrderDetails createNewOrder(Customer customer, CreateOrderRequest createOrderRequest, Inventory item) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setCustomerId(customer.getId());
        orderDetails.setItemId(item.getItemId());
        orderDetails.setItemQuantity(createOrderRequest.getNoOfItem());
        double orderPrice = item.getPricePerUnit() * createOrderRequest.getNoOfItem();
        orderDetails.setOrderPrice(orderPrice);
        return orderDetails;
    }
}
