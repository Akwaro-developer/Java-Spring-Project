package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody UserCreationParams user) {
        return userService.createUser(user);
    }

    @GetMapping("/{email}")
    public UserCreationParams getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @GetMapping
    public List<UserCreationParams> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{email}")
    public String updateUser(@PathVariable String email, @RequestBody UserCreationParams updatedUser) {
        return userService.updateUser(email, updatedUser);
    }

    @DeleteMapping("/{email}")
    public String deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }
}
