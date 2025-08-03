package com.example.multitasker.controller;

import com.example.multitasker.dto.UserRequest;
import com.example.multitasker.dto.UserResponse;
import com.example.multitasker.dto.mapper.UserMapper;
import com.example.multitasker.exception.UserNotFoundException;
import com.example.multitasker.model.User;
import com.example.multitasker.response.ResponseHandler;
import com.example.multitasker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){

        logger.info("Start UserController : createUser() method ...");

        User user = UserMapper.toEntity(userRequest);

        User savedUser = userService.createUser(user);

        UserResponse response = UserMapper.toResponse(savedUser);

        logger.debug("Saved user id: {}", savedUser.getId());

        logger.info("End UserController : createUser() method ...");

        return ResponseHandler.success("User created successfully !!!", response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) throws UserNotFoundException {

        logger.info("Start UserController : getUserById() method ...");

        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()) {

            UserResponse response = UserMapper.toResponse(user.get());

            logger.info("End UserController : getUserById() method ...");

            return ResponseHandler.success("User Found successfully !!!", response);

        }

        logger.error("End UserController : getUserById() method ...");

        return ResponseHandler.error("User is Not Found !!!", HttpStatus.NOT_FOUND);

    }

}
