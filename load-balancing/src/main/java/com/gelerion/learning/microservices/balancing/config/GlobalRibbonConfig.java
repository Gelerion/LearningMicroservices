package com.gelerion.learning.microservices.balancing.config;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;

/**
 * - list of servers
 * - health check frequency
 * - health check method
 * - load balancing strategy
 */
public class GlobalRibbonConfig {

    @Bean
    public IPing ribonPing() {
        PingUrl pingUrl = new PingUrl();
        pingUrl.setPingAppendString("/health");
        return pingUrl;
    }

    @Bean
    public IRule ribbonRule() {
        return new AvailabilityFilteringRule();
    }
}
