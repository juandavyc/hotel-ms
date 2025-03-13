package com.aleal.reservations.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "reservations")
@Data
public class ReservationsServiceConfiguration {

    private String msg;
    private String buildVersion;
    private Map<String,String> mailDetails;

}
