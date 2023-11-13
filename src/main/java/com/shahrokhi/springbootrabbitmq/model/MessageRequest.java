package com.shahrokhi.springbootrabbitmq.model;

import lombok.Data;

@Data
public class MessageRequest {
    private String receiver;
    private String message;
}
