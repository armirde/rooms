package com.uv.rooms.service;

import java.util.List;

import com.uv.rooms.model.User;

public interface UserService {
	
	List<User> findAll();
	
	User findById(Long idUser);
	
}
