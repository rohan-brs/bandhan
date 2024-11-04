package com.bandhan.order.delegate;

import com.bandhan.order.constant.OrderConstants;
import jakarta.inject.Named;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.Objects;

@Named
public class UpdateShipment implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        Object shipment = delegateExecution.getVariable(OrderConstants.SHIPMENT_TYPE);
        if (!Objects.isNull(shipment)) {
            String shipmentType = shipment.toString();
        }
    }
}
