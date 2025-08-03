package com.example.multitasker.controller;

import com.example.multitasker.dto.UserRequest;
import com.example.multitasker.dto.UserResponse;
import com.example.multitasker.dto.mapper.UserMapper;
import com.example.multitasker.exception.UserNotFoundException;
import com.example.multitasker.model.User;
import com.example.multitasker.response.ResponseHandler;
import com.example.multitasker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){

        User user = UserMapper.toEntity(userRequest);

        User savedUser = userService.createUser(user);

        UserResponse response = UserMapper.toResponse(savedUser);

        return ResponseHandler.success("User created successfully !!!", response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) throws UserNotFoundException {

        Optional<User> user = userService.getUserById(id);

        if(user.isPresent()) {

            UserResponse response = UserMapper.toResponse(user.get());

            return ResponseHandler.success("User Found successfully !!!", response);

        }

        return ResponseHandler.error("User is Not Found !!!", HttpStatus.NOT_FOUND);

    }

}
