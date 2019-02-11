package org.example.gateway;

import org.example.gateway.config.GatewayConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder, GatewayConfiguration gatewayConfiguration) {
        String httpUri = gatewayConfiguration.getHttpUri();
        String wsUri = gatewayConfiguration.getWsUri();
        return builder.routes()
                .route(p -> p
                        .path("/ws/**")
                        .uri(wsUri))
                .route(p -> p
                        .path("/**")
                        .uri(httpUri))
                .build();
    }
}

