package com.gelerion.learning.microservices.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gelerion.learning.microservices.config.client.model.Recommendation;

@RestController
@RibbonClient("sd-reco-engine") //discovered via consul app with same name
public class SdConsumerRecoController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate() { //bean will be will be intercepted and auto-configured by Spring Cloud
        return new RestTemplate();
    }

    @Autowired
    RestTemplate rest;

    @GetMapping("/sd/recommendations")
    public Recommendation get() {
        return this.rest.getForObject("http://sd-reco-engine/recommendations",
                Recommendation.class);
    }

}
