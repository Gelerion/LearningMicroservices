package com.gelerion.learning.microservices.balancing;

import com.gelerion.learning.microservices.balancing.filters.DebugFilter;
import com.gelerion.learning.microservices.balancing.filters.ResponseHeaderFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

	/**
	 * Zuul filters:
     *  pre: Filters that are executed before the request is routed (e.g. authentication, logging)
     *  routing: Filters that can handle the actual routing of the request
     *  post: Filters that are executed after the * request has been routed
     *  error: Filters that are executed on HTTP request lifecycle
	 */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public DebugFilter debugFilter() {
        return new DebugFilter();
    }

    @Bean
    public ResponseHeaderFilter responseHeaderFilter() {
        return new ResponseHeaderFilter();
    }
}
