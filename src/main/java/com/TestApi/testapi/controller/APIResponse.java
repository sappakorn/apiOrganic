package com.TestApi.testapi.controller;

import lombok.Data;

@Data
public class APIResponse {
    private String Message;
    private int status ;
    private Object data;
}
