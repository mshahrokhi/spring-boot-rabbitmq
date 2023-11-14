package com.shahrokhi.springbootrabbitmq.producer;

import com.shahrokhi.springbootrabbitmq.model.MessageRequest;

public interface MessageProducer {
    void sendSms(MessageRequest request);
    void sendEmail(MessageRequest request);
}
