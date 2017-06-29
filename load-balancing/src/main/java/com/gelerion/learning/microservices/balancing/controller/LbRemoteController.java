package com.gelerion.learning.microservices.balancing.controller;

import com.gelerion.learning.microservices.balancing.config.RecoEngineRibbonConfig;
import com.gelerion.learning.microservices.balancing.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "reco-engine", configuration = RecoEngineRibbonConfig.class)
public class LbRemoteController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/lb/my-recommendations")
    public Recommendation get() {
        return restTemplate.getForObject("http://reco-engine/recommendations",
                Recommendation.class);
    }
}
