package com.zelazobeton.cognitiveexercisesgateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Configuration
public class HostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/main", "/main/**")
                        .uri("http://localhost:8081")
                        .id("cognitive-exercises-main"))
                .route(r -> r.path("/memory", "/memory/**")
                        .uri("http://localhost:8082")
                        .id("cognitive-exercises-memory"))
                .build();
    }
}
