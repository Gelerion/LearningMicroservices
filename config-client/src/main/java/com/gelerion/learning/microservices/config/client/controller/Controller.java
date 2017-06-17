package com.gelerion.learning.microservices.config.client.controller;

import com.gelerion.learning.microservices.config.client.config.ImageServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private ImageServiceConfig config;

    @GetMapping("/host")
    ResponseEntity<?> getHost() {
        return ResponseEntity.ok(config.getHost());
    }

    @GetMapping("/port")
    ResponseEntity<?> getPort() {
        return ResponseEntity.ok(config.getPort());
    }
}
