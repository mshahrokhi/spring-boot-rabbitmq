package com.shahrokhi.springbootrabbitmq.consumer;

import com.shahrokhi.springbootrabbitmq.model.MessageRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private final Logger logger = LogManager.getLogger(MessageConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name.send-sms}")
    public void sendSmsConsumer(MessageRequest request) {
        logger.info(String.format("Consumer SMS received -> %s", request));
    }

    @RabbitListener(queues = "${rabbitmq.queue.name.send-email}")
    public void sendEmailConsumer(MessageRequest request) {
        logger.info(String.format("Consumer email received -> %s", request));
    }
}
