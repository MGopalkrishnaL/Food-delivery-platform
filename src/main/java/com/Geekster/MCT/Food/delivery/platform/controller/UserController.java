package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.User;
import com.Geekster.MCT.Food.delivery.platform.service.UserService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping(value = "/getallUsers")
    public List<User> getall(){
        return userservice.getall();
    }
    @GetMapping(value = "/login")
    public ResponseEntity login(@RequestParam String name ,@RequestParam String email){
        return userservice.login(name,email);
    }


}
