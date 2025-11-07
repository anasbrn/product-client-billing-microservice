package org.ecom.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

    //    static
//    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(r1 -> r1.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route(r2 -> r2.path("/products/**").uri("lb://PRODCUT-SERVICE"))
                .build();
    }

    @Bean
    public DiscoveryClientRouteDefinitionLocator dynamicRoutes(
            ReactiveDiscoveryClient reactiveDiscoveryClient, DiscoveryLocatorProperties properties
    ) {
        return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient, properties);
    }
}
