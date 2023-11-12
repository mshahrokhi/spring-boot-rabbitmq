package com.shahrokhi.springbootrabbitmq.model;

import lombok.Data;

@Data
public class SendSmsRequest {
    private String receiver;
    private String message;
}
