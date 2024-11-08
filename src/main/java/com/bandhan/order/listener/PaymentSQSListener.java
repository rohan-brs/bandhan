package com.bandhan.order.listener;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentSQSListener {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @SqsListener(value = "payment-sqs")
    public void getMessage(String message) {
        log.info("Message received from SQS: {}", message);
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                .processInstanceBusinessKey(message)
                .active()
                .singleResult();

        Task approvePayment = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .taskDefinitionKey("approvePayment")
                .singleResult();
        if (approvePayment != null) {
            taskService.complete(approvePayment.getId());
        }
    }
}
