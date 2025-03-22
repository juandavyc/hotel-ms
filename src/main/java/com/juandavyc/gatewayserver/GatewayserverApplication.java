package com.juandavyc.gatewayserver;

import com.thoughtworks.xstream.converters.time.LocalDateTimeConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.netty.NettyWebServer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class GatewayserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayserverApplication.class, args);
    }


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // esconder uri
                .route(p -> p
                        .path("/applications/apihotel/**")
                        .filters(f -> f
                                .rewritePath("/applications/apihotel/(?<segment>.*)", "/${segment}")
                                .addRequestHeader("X-Response-Time",new Date().toString()))
                        .uri("lb://HOTELS"))
                .route(p -> p
                        .path("/applications/apirooms/**")
                        .filters(f -> f
                                .rewritePath("/applications/apirooms/(?<segment>.*)", "/${segment}")
                                .addRequestHeader("X-Response-Time",new Date().toString()))
                        .uri("lb://ROOMS"))
                .build();

    }


}
