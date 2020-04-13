package com.uv.rooms.service;

import java.util.List;

import com.uv.rooms.model.Room;

public interface RoomService {
	
	List<Room> findAll();
	
	Room book(Long idRoom, Long idUser);
	
	Room free(Long idRoom);
	
}
