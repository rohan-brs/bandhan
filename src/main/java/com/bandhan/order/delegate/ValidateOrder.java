package com.bandhan.order.delegate;

import com.bandhan.order.dto.CreateOrderRequest;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

@Named
@Slf4j
public class ValidateOrder implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("Validating order {}", delegateExecution.getProcessInstanceId());
        CreateOrderRequest createOrderRequest = (CreateOrderRequest) delegateExecution.getVariable("order");
        delegateExecution.setVariable("isValidOrder", true);
    }
}
