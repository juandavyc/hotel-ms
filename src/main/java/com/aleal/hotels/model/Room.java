package com.aleal.hotels.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

// clase de respuesta response DTO
public class Room {

    private Long roomId;
    private Long hotelId;
    private String roomName;
    private String roomAvailable;

}
