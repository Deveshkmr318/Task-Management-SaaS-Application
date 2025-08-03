package com.example.multitasker.service;

import com.example.multitasker.exception.UserNotFoundException;
import com.example.multitasker.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    Optional<User> getUserById(Long id) throws UserNotFoundException;

    List<User> getAllUsers();

    User updateUser(Long id, User updatedUser) throws UserNotFoundException;

    void deleteUser(Long id) throws UserNotFoundException;

}
