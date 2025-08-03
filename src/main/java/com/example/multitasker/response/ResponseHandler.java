package com.example.multitasker.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data){
        return new ResponseEntity<>(new ApiResponse<>(true, message, data), HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status){
        return new ResponseEntity<>(new ApiResponse<>(false, message, null), status);
    }
}
