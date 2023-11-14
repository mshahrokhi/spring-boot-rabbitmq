package com.shahrokhi.springbootrabbitmq.producer;

import com.shahrokhi.springbootrabbitmq.model.MessageRequest;

public interface MessageProducer {
    public void sendSms(MessageRequest request);
    public void sendEmail(MessageRequest request);
}
