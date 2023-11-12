package com.shahrokhi.springbootrabbitmq.producer;

import com.shahrokhi.springbootrabbitmq.model.SendSmsRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SendSmsProducer {

    private final Logger logger = LogManager.getLogger(SendSmsProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.routing-key.send-sms}")
    private String sendSmsRoutingKey;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public SendSmsProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendSms(SendSmsRequest request) {
        logger.info(String.format("Message sent -> %s", request));
        rabbitTemplate.convertAndSend(exchangeName, sendSmsRoutingKey, request);
    }
}
