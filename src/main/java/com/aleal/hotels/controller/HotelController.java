package com.aleal.hotels.controller;

import java.util.List;

import com.aleal.hotels.config.HotelServiceConfiguration;
import com.aleal.hotels.model.PropertiesHotels;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;

@RestController
@RequiredArgsConstructor
public class HotelController {
	

	private final IHotelService service;
	private final HotelServiceConfiguration	hotelServiceConfiguration;

	
	@GetMapping("hotels")
	public List<Hotel> search(){
		return this.service.search();
	}


	@GetMapping(path = "hotels/properties")
	public String hotelProperties() throws JsonProcessingException {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		final var properties = PropertiesHotels.builder()
				.msg(hotelServiceConfiguration.getMsg())
				.buildVersion(hotelServiceConfiguration.getBuildVersion())
				.mailDetails(hotelServiceConfiguration.getMailDetails())
				.build();

		System.out.println("Get messae: " + hotelServiceConfiguration.getMsg());
		System.out.println("Hotel Properties: " + properties);
		return objectWriter.writeValueAsString(properties);
	}


}
