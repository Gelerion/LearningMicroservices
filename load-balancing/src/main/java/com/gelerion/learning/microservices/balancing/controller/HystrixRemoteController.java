package com.gelerion.learning.microservices.balancing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gelerion.learning.microservices.balancing.model.Recommendation;
import com.gelerion.learning.microservices.balancing.service.HystrixRecoService;

@RestController
public class HystrixRemoteController {

    @Autowired
    HystrixRecoService recoService;

    @GetMapping("/hystrix/my-recommendations")
    public Recommendation get() {
        return this.recoService.getRecommendations();
    }

}
