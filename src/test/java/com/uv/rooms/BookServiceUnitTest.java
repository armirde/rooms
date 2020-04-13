package com.uv.rooms;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uv.rooms.model.Room;
import com.uv.rooms.service.RoomService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceUnitTest {
	
	@Autowired
	RoomService service;
	
    @Test
    public void findAll() {
        List<Room> rooms = service.findAll();
 
        Assert.assertEquals(rooms.size(), 3);
    }

}
