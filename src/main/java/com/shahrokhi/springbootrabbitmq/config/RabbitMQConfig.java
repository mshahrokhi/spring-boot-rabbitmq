package com.shahrokhi.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.queue.name.send-sms}")
    private String sendSmsQueueName;

    @Value("${rabbitmq.queue.routing-key.send-sms}")
    private String sendSmsRoutingKey;

    @Value("${rabbitmq.queue.name.send-email}")
    private String sendEmailQueueName;

    @Value("${rabbitmq.queue.routing-key.send-email}")
    private String sendEmailRoutingKey;

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue sendSmsQueue() {
        return new Queue(sendSmsQueueName);
    }

    @Bean
    public Queue sendEmailQueue() {
        return new Queue(sendEmailQueueName);
    }

    @Bean
    public Binding sendSmsBinding() {
        return BindingBuilder
                .bind(sendSmsQueue())
                .to(exchange())
                .with(sendSmsRoutingKey);
    }

    @Bean
    public Binding sendEmailBinding() {
        return BindingBuilder
                .bind(sendEmailQueue())
                .to(exchange())
                .with(sendEmailRoutingKey);
    }
}
