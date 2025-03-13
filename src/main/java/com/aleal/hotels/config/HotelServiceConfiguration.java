package com.aleal.hotels.config;

import com.aleal.hotels.model.Hotel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "hotels")
@Data
public class HotelServiceConfiguration {

    private String msg;
    private String buildVersion;
    private Map<String, String> mailDetails;

}
