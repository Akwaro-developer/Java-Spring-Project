package com.example.myapp.controller;
//Defines the end point
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // Declares this as a REST controller
@RequestMapping("/heartbeat") // Defines the base URL
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;  // Dependency Injection (DO NOT initialize manually!)

    @GetMapping
    public int getHeartbeat() {
        return heartbeatSensor.get();
    }
}
