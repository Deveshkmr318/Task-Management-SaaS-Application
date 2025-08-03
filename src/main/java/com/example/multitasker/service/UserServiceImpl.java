package com.example.multitasker.service;

import com.example.multitasker.dto.UserRequest;
import com.example.multitasker.exception.UserNotFoundException;
import com.example.multitasker.model.User;
import com.example.multitasker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {

        User newUser = userRepo.save(user);

        return newUser;
    }

    @Override
    public Optional<User> getUserById(Long id) throws UserNotFoundException {

        Optional<User> user = userRepo.findById(id);

        if(user.isPresent()){

            return user;
        }

        throw new UserNotFoundException(" User with id " + id + " Not Found !!");
    }

    @Override
    public List<User> getAllUsers() {

        List<User> userList = userRepo.findAll();

        return userList;
    }

    @Override
    public User updateUser(Long id, User updatedUser) throws UserNotFoundException {

        Optional<User> user = getUserById(id);

        User newUser = user.get();

        newUser.setUserName(updatedUser.getUserName());
        newUser.setTask(updatedUser.getTask());
        newUser.setRole(updatedUser.getRole());
        newUser.setEmail(updatedUser.getEmail());
        newUser.setPassword(updatedUser.getPassword());
        newUser.setTenant(updatedUser.getTenant());

        return userRepo.save(newUser);

    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {

        Optional<User> user = getUserById(id);

        userRepo.deleteById(id);

    }
}
