package com.aleal.hotels.services;

import java.util.*;

import com.aleal.hotels.model.HotelRooms;
import com.aleal.hotels.model.Room;
import com.aleal.hotels.services.clients.RoomsFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.aleal.hotels.dao.IHotelDao;
import com.aleal.hotels.model.Hotel;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService {

    private final IHotelDao hotelDao;

	// ya puedo consumir servicios
	// i can consume services
    //private final RestTemplate clientRest;

    @Override
    public List<Hotel> search() {
        return (List<Hotel>) hotelDao.findAll();
    }

	private final RoomsFeignClient roomsFeignClient;

	@Override
	public HotelRooms findRoomsByHotelId(Long hotelId) {
		HotelRooms response = new HotelRooms();

		Hotel hotel = hotelDao.findById(hotelId).orElseThrow();

		List<Room> rooms = roomsFeignClient.findRoomsByHotelId(hotelId);

		response.setHotelId(hotel.getHotelId());
		response.setHotelName(hotel.getHotelName());
		response.setHotelAddress(hotel.getHotelAddress());
		response.setRooms(rooms);

		return response;
	}

	@Override
	public HotelRooms findRoomsByHotelIdWithoutRooms(Long hotelId) {
		HotelRooms response = new HotelRooms();

		Hotel hotel = hotelDao.findById(hotelId).orElseThrow();
		response.setHotelId(hotel.getHotelId());
		response.setHotelName(hotel.getHotelName());
		response.setHotelAddress(hotel.getHotelAddress());
		response.setRooms(List.of());

		return response;
	}


// TODO: with rest template
//    @Override
//    public HotelRooms findRoomsByHotelId(Long hotelId) {
//
//		HotelRooms response = new HotelRooms();
//		Hotel hotel = hotelDao.findById(hotelId).orElseThrow();
//
//		Map<String,Long> pathVariable = new HashMap<String,Long>();
//
//		pathVariable.put("id", hotelId);
//
//		List<Room> rooms = Arrays.asList(clientRest.getForObject(
//				"http://localhost:8081/rooms/{id}",
//				Room[].class,
//				pathVariable
//		));
//
//		response.setHotelId(hotel.getHotelId());
//		response.setHotelName(hotel.getHotelName());
//		response.setHotelAddress(hotel.getHotelAddress());
//		response.setRooms(rooms);
//
//        return response;
//    }

}
