package com.uv.rooms;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uv.rooms.model.User;
import com.uv.rooms.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceUnitTest {
	
	@Autowired
	UserService service;
	
    @Test
    public void findAll() {
        List<User> Users = service.findAll();
 
        Assert.assertEquals(Users.size(), 2);
    }

}
