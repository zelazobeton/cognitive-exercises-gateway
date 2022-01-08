package com.zelazobeton.cognitiveexercisesgateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Configuration
public class HostRouteConfig {

    @Value("${cognitive-exercises-main-host}")
    private String mainMicroserviceHost;

    @Value("${cognitive-exercises-memory-host}")
    private String memoryMicroserviceHost;

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/main", "/main/**")
                        .uri(this.mainMicroserviceHost)
                        .id("cognitive-exercises-main"))
                .route(r -> r.path("/memory", "/memory/**")
                        .uri(this.memoryMicroserviceHost)
                        .id("cognitive-exercises-memory"))
                .build();
    }
}
