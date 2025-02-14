
package com.example.myapp.controller;

public class UserCreationParams {
    private String name;
    private String email;
    private int age;
    private String password;

    // Constructors
    public UserCreationParams() {
    }

    public UserCreationParams(String name, String email, int age, String password) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Convert UserCreationParams to UserDto (to exclude password)
    public UserDto toUserDto() {
        return new UserDto(this.name, this.email, this.age);
    }
}