package com.example.myapp.controller;

import org.springframework.stereotype.Service;
import com.example.myapp.controller.UserDto;
import com.example.myapp.controller.UserCreationParams;
import com.example.myapp.controller.UserCreationParams;

import java.util.List;


public interface UserService {

    String createUser(UserCreationParams user);
    UserCreationParams getUser(String email);
    String updateUser(String email, UserCreationParams updatedUser);
    String deleteUser(String email);
    List<UserCreationParams> getAllUsers();
}
