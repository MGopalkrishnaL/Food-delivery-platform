package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.Order;
import com.Geekster.MCT.Food.delivery.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping(value = "/create-order")
    public ResponseEntity saveorder(@RequestBody String order){
        return orderService.saveorders(order);
    }
    @GetMapping(value = "/get-all")
    public List<Order> getall(){
        return orderService.getall();
    }
    @GetMapping(value = "/getorderbyuserId")
    public List<Order> getallorders(@RequestParam Integer id){
        return orderService.getorderbyuserid(id);
    }
}
