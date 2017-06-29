package com.gelerion.learning.microservices.balancing;

import com.gelerion.learning.microservices.balancing.config.RecoEngineRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//https://github.com/Netflix/Hystrix/wiki/Configuration
@EnableHystrix //enables hystrix.stream events stream or /hystrix for the UI
@EnableHystrixDashboard
@ComponentScan(excludeFilters = {
        //exclude RecoEngineRibbonConfig class to be scanned by Spring
     @Filter(type = FilterType.ASSIGNABLE_TYPE, classes = RecoEngineRibbonConfig.class)
})
public class LbApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbApplication.class, args);
    }


    @Bean
    @LoadBalanced
    //this bean will be will be intercepted and auto-configured by Spring Cloud to use a custom HttpRequestClient that uses Ribbon
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
