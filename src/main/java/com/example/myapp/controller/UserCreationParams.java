
package com.example.myapp.controller;
//UserCreationParams
//A DTO (Data Transfer Object) used to transfer data between the client and the server.

//Contains fields like name, email, age, and password.

//Includes getters and setters for accessing and modifying the fields.

//Also has a method toUserDto() to convert UserCreationParams to UserDto (excluding the password for security reasons).

public class UserCreationParams {
    private String name;
    private String email;
    private int age;
    private String password;

    // Constructors

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