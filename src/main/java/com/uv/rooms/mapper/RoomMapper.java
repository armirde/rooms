package com.uv.rooms.mapper;

import java.util.ArrayList;
import java.util.List;

import com.uv.rooms.dto.RoomDto;
import com.uv.rooms.model.Room;

public class RoomMapper {
	
	public static RoomDto fromEntity(Room entity) {
		
		if ( entity == null) {
			return null;
		}
		
		RoomDto dto = new RoomDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setUser(UserMapper.fromEntity(entity.getUser()));
		
		return dto;
	}
	
	public static List<RoomDto> fromEntityList(List<Room> entities) {
		
		if ( entities == null) {
			return null;
		}
		
		List<RoomDto> list = new ArrayList<RoomDto>(entities.size());
		for(Room entity : entities) {
			list.add(fromEntity(entity));
		}
		
		return list;
	}

}