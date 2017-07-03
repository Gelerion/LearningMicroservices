package com.gelerion.learning.microservices.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ConsumerApplication {

    //-Dserver.port=8091 -Dapplication.name=sd.reco-engine-1 spring-boot:run
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
