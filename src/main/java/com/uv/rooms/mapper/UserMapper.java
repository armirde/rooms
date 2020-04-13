package com.uv.rooms.mapper;

import java.util.ArrayList;
import java.util.List;

import com.uv.rooms.dto.UserDto;
import com.uv.rooms.model.User;

public class UserMapper {
	
	public static UserDto fromEntity(User entity) {
		
		if ( entity == null) {
			return null;
		}
		
		UserDto dto = new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		
		return dto;
	}
	
	public static List<UserDto> fromEntityList(List<User> entities) {
		
		if ( entities == null) {
			return null;
		}
		
		List<UserDto> list = new ArrayList<UserDto>(entities.size());
		for(User entity : entities) {
			list.add(fromEntity(entity));
		}
		
		return list;
	}

}