package com.example.myapp.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    private final Map<String, UserCreationParams> users = new HashMap<>();

    @Override
    public String createUser(UserCreationParams user) {
        users.put(user.getEmail(), user);
        return "User created successfully!";
    }

    @Override
    public UserCreationParams getUser(String email) {
        return users.get(email);
    }

    @Override
    public List<UserCreationParams> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String updateUser(String email, UserCreationParams updatedUser) {
        if (users.containsKey(email)) {
            users.put(email, updatedUser);
            return "User updated successfully!";
        }
        return "User not found!";
    }

    @Override
    public String deleteUser(String email) {
        return users.remove(email) != null ? "User deleted successfully!" : "User not found!";
    }
}
