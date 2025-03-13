package com.aleal.reservations.controller;

import java.util.List;

import com.aleal.reservations.config.ReservationsServiceConfiguration;
import com.aleal.reservations.model.PropertiesReservations;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.reservations.model.Reservation;
import com.aleal.reservations.services.IReservationService;

@RestController
@RequiredArgsConstructor
public class ReservationController {
	

	private final IReservationService service;
	private final ReservationsServiceConfiguration reservationsServiceConfiguration;

	@GetMapping("reservations")
	public List<Reservation> search(){
		return (List<Reservation>) this.service.search();	
	}

	@GetMapping(path = "reservations/properties")
	public String reservationsProperties() throws JsonProcessingException {
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();



		final var properties = PropertiesReservations.builder()
				.msg(reservationsServiceConfiguration.getMsg())
				.buildVersion(reservationsServiceConfiguration.getBuildVersion())
				.mailDetails(reservationsServiceConfiguration.getMailDetails())
				.build();
		return objectWriter.writeValueAsString(properties);
	}



}
