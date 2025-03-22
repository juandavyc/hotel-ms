package com.aleal.hotels.model;

import lombok.Data;

import java.util.List;


@Data
// clase de respuesta response DTO
public class HotelRooms {

    private Long hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;

}
