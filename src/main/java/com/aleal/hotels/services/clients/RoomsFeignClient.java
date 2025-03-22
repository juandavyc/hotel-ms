package com.aleal.hotels.services.clients;

import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("rooms")
public interface RoomsFeignClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "rooms/{id}",
            consumes = "application/json"
    )

    List<Room> findRoomsByHotelId(@PathVariable Long id);

}
