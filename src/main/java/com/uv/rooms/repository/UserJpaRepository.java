package com.uv.rooms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uv.rooms.model.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Long> {
}