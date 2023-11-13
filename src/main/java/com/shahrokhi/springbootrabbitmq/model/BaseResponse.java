package com.shahrokhi.springbootrabbitmq.model;

import lombok.Data;

@Data
public class BaseResponse {
    private String resultCode;
    private String resultDesc;

    public void setSuccess() {
        this.resultCode = "200";
        this.resultDesc = "Success";
    }
}
