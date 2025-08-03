package com.example.multitasker.dto;

import lombok.Data;

@Data
public class UserRequest {

    private String userName;

    private String password;

    private String email;

    private String role;

    private Long tenantId;
}
