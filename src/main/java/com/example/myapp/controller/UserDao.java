package com.example.myapp.controller;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {
    @NotNull
    Stream<User> findAll();

    Optional<User> findById(@NotNull UUID userId);

    void upsert(@NotNull User user);

    void delete(@NotNull UUID userId);
}
