package com.aleal.hotels.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class AppConfig {

    // ocuparlo donde queramos
    // para consumir otro ms
    @Bean("clientRest")
    public RestTemplate registerRestTemplate() {
        return new RestTemplate();
    }



}
