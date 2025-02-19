package com.example.myapp.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository//
public class InMemoryUserDao implements UserDao{
    private final Map<UUID, User> users = new HashMap<>();

    @Override
    public @NotNull Stream<User> findAll() {
        return users.values().stream();
    }

    @Override
    public Optional<User> findById(@NotNull UUID userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public void upsert(@NotNull User user) {
        if (user.getId() == null) {
            user.setId(UUID.randomUUID()); // To generate the ID of the user
        }
        users.put(user.getId(), user);
    }

    @Override
    public void delete(@NotNull UUID userId) {
        users.remove(userId);
    }

}
