package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // Constructor injection (with @Autowired)
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE (POST) - Add a new user
    @PostMapping
    public String createUser(@RequestBody UserCreationParams user) {
        return userService.createUser(user);
    }

    // READ (GET) - Retrieve user by email
    @GetMapping("/{email}")
    public UserCreationParams getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    // READ (GET) - Retrieve all users
    @GetMapping
    public List<UserCreationParams> getAllUsers() {
        return userService.getAllUsers();
    }

    // UPDATE (PUT) - Update an existing user
    @PutMapping("/{email}")
    public String updateUser(@PathVariable String email, @RequestBody UserCreationParams updatedUser) {
        return userService.updateUser(email, updatedUser);
    }

    // DELETE (DELETE) - Remove a user
    @DeleteMapping("/{email}")
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }
}
