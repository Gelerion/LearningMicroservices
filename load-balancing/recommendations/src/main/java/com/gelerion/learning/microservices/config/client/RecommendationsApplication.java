package com.gelerion.learning.microservices.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//-Dserver.port=8091 -Dapplication.name=reco-engine-1 spring-boot:run
@SpringBootApplication
public class RecommendationsApplication {

    //The application will start on port 8585 because configuration file that is loaded from the config server has this property
    public static void main(String[] args) {
        SpringApplication.run(RecommendationsApplication.class, args);
    }
}
