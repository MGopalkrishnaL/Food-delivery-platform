package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.User;
import com.Geekster.MCT.Food.delivery.platform.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    UserService userservice;
    @PostMapping(value = "/create-user")
    public User saveuser(@Valid @RequestBody User user){
        return userservice.addUser(user);
    }
    @PostMapping(value = "/getallUsers")
    public List<User> getall(){
        return userservice.getall();
    }

}
