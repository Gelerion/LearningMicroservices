package com.gelerion.learning.microservices.config.client.controller;

import com.gelerion.learning.microservices.config.client.model.Artist;
import com.gelerion.learning.microservices.config.client.model.Meta;
import com.gelerion.learning.microservices.config.client.model.Recommendation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RecommendationController {
    @Value("${application.name:default}")
    private String applicationName;

    @GetMapping("/recommendations")
    Recommendation getRecomendations() {
        Recommendation recommendation = new Recommendation();
        recommendation.setMeta(new Meta(applicationName));
        recommendation.setRecommendations(getArtistRecommendation());
        return recommendation;
    }

    private List<Artist> getArtistRecommendation() {
        List<Artist> artistList = new ArrayList<>();
        artistList.add(new Artist("51c6188d", "Solomon Burke"));
        artistList.add(new Artist("095d08a9", "Yann Tiersen"));
        artistList.add(new Artist("592029de", "Lizz Wright"));
        artistList.add(new Artist("4f3c89e7", "Aynur"));
        artistList.add(new Artist("b61bbc1a", "Alexi Murdoch"));
        return artistList;
    }
}
