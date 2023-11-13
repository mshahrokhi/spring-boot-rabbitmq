package com.shahrokhi.springbootrabbitmq.controller;

import com.shahrokhi.springbootrabbitmq.model.MessageRequest;
import com.shahrokhi.springbootrabbitmq.model.MessageResponse;
import com.shahrokhi.springbootrabbitmq.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping("/sendSms")
    public MessageResponse sendSms(@RequestBody MessageRequest request) {
        messageService.sendSms(request);
        MessageResponse response = new MessageResponse();
        response.setSuccess();
        return response;
    }

    @RequestMapping("/sendEmail")
    public MessageResponse sendEmail(@RequestBody MessageRequest request) {
        messageService.sendEmail(request);
        MessageResponse response = new MessageResponse();
        response.setSuccess();
        return response;
    }

}
