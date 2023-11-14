package com.shahrokhi.springbootrabbitmq.producer;

import com.shahrokhi.springbootrabbitmq.model.MessageRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerImp implements MessageProducer {

    private final Logger logger = LogManager.getLogger(MessageProducerImp.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.routing-key.send-sms}")
    private String sendSmsRoutingKey;

    @Value("${rabbitmq.queue.routing-key.send-email}")
    private String sendEmailRoutingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageProducerImp(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendSms(MessageRequest request) {
        logger.info(String.format("Producer SMS sent -> %s", request));
        rabbitTemplate.convertAndSend(exchangeName, sendSmsRoutingKey, request);
    }

    @Override
    public void sendEmail(MessageRequest request) {
        logger.info(String.format("Producer email sent -> %s", request));
        rabbitTemplate.convertAndSend(exchangeName, sendEmailRoutingKey, request);
    }
}
