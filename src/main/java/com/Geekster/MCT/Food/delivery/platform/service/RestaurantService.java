package com.Geekster.MCT.Food.delivery.platform.service;

import com.Geekster.MCT.Food.delivery.platform.dao.IRestaurantRepo;
import com.Geekster.MCT.Food.delivery.platform.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    IRestaurantRepo restaurantRepo;
    public ResponseEntity saveres(Restaurant restaurant) {
        restaurantRepo.save(restaurant);
        return new ResponseEntity<>("Data saved successfully", HttpStatus.CREATED);
    }
    public List<Restaurant> getallRest(){
        return restaurantRepo.findAll();
    }
}
