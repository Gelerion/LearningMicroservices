package com.gelerion.learning.microservices.service.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//annotation auto configures service to register itself and act as a client to query Consul to locate other services.
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceDiscoveryApplication {

    //assuming consul's HTTP API is running on your localhost at port 8500 (consul agent -dev)
    public static void main(String[] args) {
        SpringApplication.run(ServiceDiscoveryApplication.class, args);
    }
}
