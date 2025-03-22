package com.aleal.hotels;

import com.aleal.hotels.config.HotelServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableConfigurationProperties(HotelServiceConfiguration.class)
@EnableFeignClients
public class HotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelsApplication.class, args);
	}

}
