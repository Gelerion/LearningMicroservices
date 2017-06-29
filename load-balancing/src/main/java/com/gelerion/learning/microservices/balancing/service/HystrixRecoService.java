package com.gelerion.learning.microservices.balancing.service;

import com.gelerion.learning.microservices.balancing.model.Artist;
import com.gelerion.learning.microservices.balancing.model.Meta;
import com.gelerion.learning.microservices.balancing.model.Recommendation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
//@RibbonClient(name = "reco-engine")
public class HystrixRecoService {

    @Autowired
    RestTemplate rest;

/*    When the circuit is open all calls to service will fail, but what do we do with failing request?
    There is a possibility to provide a fallback method in case circuit is open. In our case, the fallback
    method can deliver a reduced set of default recommendations. Therefore, we decorate the getRecommendations()
    method with @HystrixCommand and give fallback method name which is in the same class. There is another
    property added which is called commandKey, which defines a name for this particular command.*/

    @HystrixCommand(fallbackMethod = "getDefaultRecommendations", commandKey = "recommendationCommand")
    public Recommendation getRecommendations() {
        return this.rest.getForObject("http://reco-engine/recommendations",
                Recommendation.class);
    }

    Recommendation getDefaultRecommendations() {
        Recommendation recommendation = new Recommendation();
        recommendation.setMeta(new Meta("default"));
        recommendation.setRecommendations(getArtistRecommendations());
        return recommendation;
    }
    
	List<Artist> getArtistRecommendations() {
		List<Artist> artistList = new ArrayList<>();
		artistList.add(new Artist("2f504a21", "Adele"));
		artistList.add(new Artist("8c1d906e", "Duman"));
		artistList.add(new Artist("5d164854", "The Beatles"));
		return artistList;
	}

}
