package com.bandhan.order.delegate;

import com.bandhan.order.constant.OrderConstants;
import com.bandhan.order.service.OrderService;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@Named
public class UpdateOrder implements JavaDelegate {

    @Autowired
    private OrderService orderService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object shipmentType = delegateExecution.getVariable(OrderConstants.SHIPMENT_TYPE);
        Object orderId = delegateExecution.getVariable(OrderConstants.ORDER_ID);
        if (Objects.isNull(shipmentType) || Objects.isNull(orderId)) {
            throw new Exception("Invalid details for orderId or shipment type");
        }
        orderService.updateOrder(Integer.parseInt(orderId.toString()), shipmentType.toString());

    }
}
