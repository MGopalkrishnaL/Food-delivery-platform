package com.Geekster.MCT.Food.delivery.platform.service;

import com.Geekster.MCT.Food.delivery.platform.dao.IFoodItemRepo;
import com.Geekster.MCT.Food.delivery.platform.dao.IOrderRepo;
import com.Geekster.MCT.Food.delivery.platform.dao.IUserRepo;
import com.Geekster.MCT.Food.delivery.platform.model.FoodItem;
import com.Geekster.MCT.Food.delivery.platform.model.Order;
import com.Geekster.MCT.Food.delivery.platform.model.User;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IFoodItemRepo foodItemRepo;
    public ResponseEntity saveorders(String orderdetails) {
        Order order= stringToJson(orderdetails);
        orderRepo.save(order);
        return new ResponseEntity<>("Data saved successfully", HttpStatus.CREATED);
    }

    public List<Order> getall() {
        return orderRepo.findAll();
    }
    public Order stringToJson(String order){
        JSONObject json = new JSONObject(order);
        Order order1 = new Order();
        order1.setOrderId(json.getInt("orderId"));
        User user = userRepo.findById(json.getInt("userid")).get();
        order1.setUserid(user);
        FoodItem foodItem = foodItemRepo.findById(json.getInt("foodId")).get();
        order1.setFoodId(foodItem);
        return order1;
    }


    public List<Order> getorderbyuserid(Integer id) {
        return orderRepo.getAllOrder(Integer id);
    }

}
