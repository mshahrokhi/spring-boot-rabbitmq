package com.shahrokhi.springbootrabbitmq.service;

import com.shahrokhi.springbootrabbitmq.model.MessageRequest;
import com.shahrokhi.springbootrabbitmq.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageProducer messageProducer;

    @Autowired
    public MessageService(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public void sendSms(MessageRequest request) {
        messageProducer.sendSms(request);
    }

    public void sendEmail(MessageRequest request) {
        messageProducer.sendEmail(request);
    }
}
