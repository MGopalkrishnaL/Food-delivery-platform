package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.Order;
import com.Geekster.MCT.Food.delivery.platform.service.OrderService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping(value = "/create-order")
    public ResponseEntity<String> createOrder(@RequestBody String orderrequest){
        return orderService.createOrder(orderrequest);
    }

    @GetMapping(value = "/get-order-by-orderid")
    public ResponseEntity<String> getOrder(@Valid @Nullable @RequestParam String orderId){
        return orderService.getorder(orderId);
    }
}
