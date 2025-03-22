package com.aleal.rooms.controller;

import java.util.List;

import com.aleal.rooms.config.RoomServiceConfig;
import com.aleal.rooms.model.PropertiesRoom;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aleal.rooms.model.Room;
import com.aleal.rooms.services.IRoomService;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RoomController {


	private final IRoomService service;
	private final RoomServiceConfig roomServiceConfig;

	
	@GetMapping("rooms")
	public List<Room> search(){
		log.info("Searching reservations");
		return (List<Room>) this.service.search();
	}

	@GetMapping("rooms/{id}")
	public List<Room> fetchRoomById(@PathVariable Long id){
		log.info("Searching reservations with id {}", id);
		return (List<Room>) this.service.findRoomsByHotelId(id);
	}



	@GetMapping(path = "rooms/properties")
	public String propertiesRoom() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();


		final var properties = PropertiesRoom.builder()
				.msg(roomServiceConfig.getMsg())
				.buildVersion(roomServiceConfig.getBuildVersion())
				.mailDetails(roomServiceConfig.getMailDetails())
				.build();

		return ow.writeValueAsString(properties);

	}








}
