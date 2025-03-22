package com.aleal.rooms.services;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aleal.rooms.dao.IRoomDao;
import com.aleal.rooms.model.Room;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class RoomServiceImpl implements IRoomService {
	
	private final IRoomDao roomDao;

	@Override
	public List<Room> search() {
		return (List<Room>) roomDao.findAll();
	}

	@Override
	public List<Room> findRoomsByHotelId(Long id) {
		List<Room> rooms = roomDao.findByHotelId(id);

		return rooms;
	}

}
