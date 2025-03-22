package com.aleal.hotels.controller;

import java.util.List;

import com.aleal.hotels.config.HotelServiceConfiguration;
import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.PropertiesHotels;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.hotels.model.Hotel;
import com.aleal.hotels.services.IHotelService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HotelController {


	private final IHotelService service;
	private final HotelServiceConfiguration	hotelServiceConfiguration;

	
	@GetMapping("hotels")
	public List<Hotel> search(){
		log.info("Searching hotels");
		return this.service.search();
	}

	@GetMapping("hotels/{id}")
	// @Retry(name = "searchHotelByIdSupportRetry",fallbackMethod = "findRoomsByHotelIdWithoutRooms")
	@CircuitBreaker(name = "searchHotelByIdSupportCB")
	public HotelRooms findByHotelId(@PathVariable Long id){
		log.info("Searching hotel with id {}", id);
		return this.service.findRoomsByHotelId(id);
	}

	public HotelRooms findRoomsByHotelIdWithoutRooms(
			@PathVariable Long id,
			Throwable throwable
			){
		return this.service.findRoomsByHotelIdWithoutRooms(id);
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
