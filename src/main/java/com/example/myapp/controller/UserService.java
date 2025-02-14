package com.example.myapp.controller;

import java.util.List;

public interface UserService {

    String createUser(UserCreationParams user);
    UserCreationParams getUser(String email);
    List<UserCreationParams> getAllUsers();
    String updateUser(String email, UserCreationParams updatedUser);
    String deleteUser(String email);
}
