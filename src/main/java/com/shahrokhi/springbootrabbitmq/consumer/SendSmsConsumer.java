package com.shahrokhi.springbootrabbitmq.consumer;

import com.shahrokhi.springbootrabbitmq.model.SendSmsRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;

public class SendSmsConsumer {

    private final Logger logger = LogManager.getLogger(SendSmsConsumer.class);

    @Value("${rabbitmq.queue.name.send-sms}")
    private String sendSmsQueueName;

    @RabbitListener(queues = {"${rabbitmq.queue.name.send-sms}"})
    public void sendSmsConsumer(SendSmsRequest request) {
        logger.info(String.format("Request received -> %s", request));
    }
}
