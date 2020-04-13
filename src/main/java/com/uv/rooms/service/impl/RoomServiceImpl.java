package com.uv.rooms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uv.rooms.model.Room;
import com.uv.rooms.model.User;
import com.uv.rooms.repository.RoomJpaRepository;
import com.uv.rooms.service.RoomService;
import com.uv.rooms.service.UserService;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomJpaRepository repository;
	
	@Autowired
	UserService userService;

	@Override
	public List<Room> findAll() {
		return repository.findAll();
	}

	@Override
	public Room book(Long idRoom, Long idUser) {
		Optional<Room> optional = repository.findById(idRoom);
		
		if(optional.isPresent()) {
			Room room = optional.get();
			User user = userService.findById(idUser);
			if(room.getUser() == null && user != null) {
				room.setUser(user);
				repository.save(room);
				return room;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public Room free(Long idRoom) {
		Optional<Room> optional = repository.findById(idRoom);
		
		if(optional.isPresent()) {
			Room room = optional.get();
			room.setUser(null);
			repository.save(room);
			return room;
		} else {
			return null;
		}
	}

}
