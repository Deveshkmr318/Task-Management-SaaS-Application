package com.example.multitasker.dto.mapper;

import com.example.multitasker.controller.UserController;
import com.example.multitasker.dto.UserRequest;
import com.example.multitasker.dto.UserResponse;
import com.example.multitasker.model.Tenant;
import com.example.multitasker.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserMapper {

    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    public static User toEntity(UserRequest userRequest){

        logger.info("Start UserMapper : toEntity() method ...");

        User user = new User();

        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setRole(userRequest.getRole());
        user.setPassword(userRequest.getPassword());
//        user.setTenant(new Tenant());

        logger.debug("User user -> " + user);
        logger.debug("UserRequest userRequest -> " + userRequest);

        logger.info("End UserMapper : toEntity() method ...");

        return user;
    }

    public static UserResponse toResponse(User user){

        logger.info("Start UserMapper : toResponse() method ...");

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPassword(user.getPassword());
        userResponse.setRole(user.getRole());
        userResponse.setUserName(user.getUserName());
        userResponse.setTenantId(user.getTenant() != null ? user.getTenant().getId() : null);

        logger.debug("User user -> " + user);
        logger.debug("UserResponse userResponse -> " + userResponse);

        logger.info("End UserMapper : toResponse() method ...");

        return userResponse;
    }
}
