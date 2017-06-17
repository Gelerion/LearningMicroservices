package com.gelerion.learning.microservices.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {

    //The application will start on port 8585 because configuration file that is loaded from the config server has this property
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }
}
