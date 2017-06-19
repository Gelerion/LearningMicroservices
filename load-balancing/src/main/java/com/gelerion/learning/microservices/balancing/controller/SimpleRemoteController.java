package com.gelerion.learning.microservices.balancing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gelerion.learning.microservices.balancing.model.Recommendation;

//connects to RecommendationController
@RestController
public class SimpleRemoteController {

	@GetMapping("/simple/my-recommendations")
	public Recommendation get() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8091/recommendations",
                Recommendation.class);
	}
}
