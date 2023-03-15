package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.Restaurant;
import com.Geekster.MCT.Food.delivery.platform.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/restaurant")
public class RestaurantController {
    @Autowired
    RestaurantService service;
    @PostMapping(value = "/create-restaurent")
    public ResponseEntity saverest(@RequestBody Restaurant restaurant){
        return service.saveres(restaurant);
    }
    @GetMapping(value = "/get-all-restaurant")
    public List<Restaurant> getall(){
        return service.getallRest();
    }

}
