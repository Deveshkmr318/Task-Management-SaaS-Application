package com.example.multitasker.dto.mapper;

import com.example.multitasker.dto.UserRequest;
import com.example.multitasker.dto.UserResponse;
import com.example.multitasker.model.User;

public class UserMapper {

    public static User toEntity(UserRequest userRequest){

        User user = new User();

        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());

        return user;
    }

    public static UserResponse toResponse(User user){

        UserResponse userResponse = new UserResponse();

        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setRole(user.getRole());
        userResponse.setUserName(user.getUserName());
        userResponse.setTenantId(user.getTenant().getId());

        return userResponse;
    }
}
