package com.uv.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uv.rooms.dto.UserDto;
import com.uv.rooms.mapper.UserMapper;
import com.uv.rooms.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/findAll")
	List<UserDto> findAll() {
		return UserMapper.fromEntityList(service.findAll());
	}

}
