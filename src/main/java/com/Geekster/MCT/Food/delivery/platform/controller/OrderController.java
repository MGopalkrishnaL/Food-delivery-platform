package com.Geekster.MCT.Food.delivery.platform.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {
    @PostMapping(value = "/create-order")
    
}
