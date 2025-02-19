package com.example.myapp.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public class JdbcUserDao implements UserDao {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcUserDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public @NotNull Stream<User> findAll() {
        String sql = "SELECT * FROM users";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users.stream();
    }

    @Override
    public Optional<User> findById(@NotNull UUID userId) {
        String sql = "SELECT * FROM users WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", userId.toString());
        List<User> users = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(User.class));
        return users.stream().findFirst();
    }

    @Override
    public void upsert(@NotNull User user) {
        System.out.println("Inserting/Updating user: " + user);
        String sql = """
        INSERT INTO users (id, name, age, email, password, role) 
        VALUES (:id, :name, :age, :email, :password, :role) 
        ON CONFLICT (id) DO UPDATE SET 
            name = EXCLUDED.name,
            age = EXCLUDED.age,
            email = EXCLUDED.email,
            password = EXCLUDED.password,
            role = EXCLUDED.role
        """;
        jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public void delete(@NotNull UUID userId) {
        String sql = "DELETE FROM users WHERE id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource("id", userId.toString());
        jdbcTemplate.update(sql, params);
    }

}
