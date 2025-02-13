package com.example.myapp.controller;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service  // Marks this as a Spring-managed service
public class RandomHeartbeat implements HeartbeatSensor {
    private final Random random = new Random();

    @Override
    public int get() {
        return this.random.nextInt(40,250);  // Returns a random heartbeat between 60-100
    }
}
