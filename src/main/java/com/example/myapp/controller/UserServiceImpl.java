package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(@Qualifier("jdbcUserDao") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String createUser(User user) {
        user.setId(UUID.randomUUID());
        userDao.upsert(user);
        return "User created successfully!";
    }

    @Override
    public User getUser(UUID userId) {
        return userDao.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll().collect(Collectors.toList());
    }

    @Override
    public String updateUser(UUID userId, User updatedUser) {
        if (userDao.findById(userId).isEmpty()) {
            throw new RuntimeException("User not found");
        }
        updatedUser.setId(userId);
        userDao.upsert(updatedUser);
        return "User updated successfully!";
    }

    @Override
    public String deleteUser(UUID userId) {
        if (userDao.findById(userId).isEmpty()) {
            throw new RuntimeException("User not found");
        }
        userDao.delete(userId);
        return "User deleted successfully!";
    }
}
