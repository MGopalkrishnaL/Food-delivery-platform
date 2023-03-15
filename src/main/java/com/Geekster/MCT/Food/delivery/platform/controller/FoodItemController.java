package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.FoodItem;
import com.Geekster.MCT.Food.delivery.platform.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/food")
public class FoodItemController {
    @Autowired
    FoodItemService foodservice;

    @PostMapping(value="/create-food_item")
    public FoodItem savefood(@Valid @RequestBody FoodItem foodItem){
        return foodservice.savefood(foodItem);
    }
    @GetMapping(value = "/getAllfoodItems")
    public List<FoodItem> getallfood(){
        return foodservice.getall();
    }
    @GetMapping(value = "/getfoodbyId")
    public FoodItem getbyid(@RequestParam Integer foodid){
        return foodservice.getfoodbyId(foodid);
    }
    @DeleteMapping(value = "/delete-food-by-id")
    public ResponseEntity deletebyid(@RequestParam Integer foodid){
        foodservice.deletefood(foodid);
        return new ResponseEntity<>("Food item is deleted successfully", HttpStatus.OK);
    }
    @PutMapping(value = "/update-food-item/{foodid}")
    public ResponseEntity updatefood(@PathVariable Integer foodid,@RequestBody FoodItem foodItem){
        foodservice.updatefood(foodid,foodItem);
        return new ResponseEntity<>("Update the food item",HttpStatus.ACCEPTED);
    }
}
