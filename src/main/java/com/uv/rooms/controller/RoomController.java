package com.uv.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uv.rooms.dto.BookDto;
import com.uv.rooms.dto.RoomDto;
import com.uv.rooms.mapper.RoomMapper;
import com.uv.rooms.service.RoomService;

@RestController
@RequestMapping(value = "room")
public class RoomController {
	
	@Autowired
	RoomService service;
	
	@GetMapping("/findAll")
	List<RoomDto> findAll() {
		return RoomMapper.fromEntityList(service.findAll());
	}
	
	@PostMapping("/book")
	RoomDto book(@RequestBody BookDto dto) {
		return RoomMapper.fromEntity(service.book(dto.getRoom().getId(), dto.getUser().getId()));
	}
	
	@GetMapping("/free/{id}")
	RoomDto free(@PathVariable Long id) {
		return RoomMapper.fromEntity(service.free(id));
	}

}
