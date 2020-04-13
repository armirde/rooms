package com.uv.rooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uv.rooms.model.Room;


@Repository
public interface RoomJpaRepository extends JpaRepository<Room, Long> {
}