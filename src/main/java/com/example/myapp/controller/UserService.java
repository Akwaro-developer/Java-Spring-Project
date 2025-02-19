package com.example.myapp.controller;

import java.util.List;
import java.util.UUID;

//Defines the contract for the service layer.
//
//Contains methods like createUser, getUser, getAllUsers, updateUser, and deleteUser.
public interface UserService {
    String createUser(User user);
    User getUser(UUID userId);
    List<User> getAllUsers();
    String updateUser(UUID userId, User updatedUser);
    String deleteUser(UUID userId);

}
