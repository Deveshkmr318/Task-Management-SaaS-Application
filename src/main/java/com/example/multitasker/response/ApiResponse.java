package com.example.multitasker.response;

import lombok.Data;

@Data
public class ApiResponse<T> {

    private boolean status;
    private String message;
    private T data;

    public ApiResponse(){

    }

    public ApiResponse(boolean status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
