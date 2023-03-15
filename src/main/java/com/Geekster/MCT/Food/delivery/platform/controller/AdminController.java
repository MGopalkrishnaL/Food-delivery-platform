package com.Geekster.MCT.Food.delivery.platform.controller;

import com.Geekster.MCT.Food.delivery.platform.model.Admin;
import com.Geekster.MCT.Food.delivery.platform.model.FoodItem;
import com.Geekster.MCT.Food.delivery.platform.model.Order;
import com.Geekster.MCT.Food.delivery.platform.service.AdminService;
import com.Geekster.MCT.Food.delivery.platform.service.FoodItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    FoodItemService foodItemService;

    @PostMapping(value = "/creat-admin")
    public ResponseEntity addAdmin(@Valid @RequestBody Admin admindetails){
       return adminService.savedata(admindetails);
    }
    @GetMapping(value = "/getadmin")
    public List<Admin> getAll(){
        return adminService.showAll();
    }
    @PostMapping(value = "/create-food-item")
    public ResponseEntity createfood(@RequestBody FoodItem foodItem){
        foodItemService.savefood(foodItem);
        return new ResponseEntity<>("Food Item was created by the Admin", HttpStatus.CREATED);
    }
    @GetMapping(value = "/getallfood")
    public ResponseEntity getallfood(){
        List<FoodItem> foodItems = foodItemService.getall();
        return new ResponseEntity<>("Admin getting all the foods - "+foodItems,HttpStatus.OK);
    }
    @DeleteMapping(value = "/deletefoodbyid")
    public ResponseEntity deletefood(@RequestParam Integer foodId){
        if(foodItemService.getfoodbyId(foodId)!=null) {
            foodItemService.deletefood(foodId);
        }else{
            return new ResponseEntity<>("FoodItem with the following id is not present in the database",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("FoodItem is deleted successfully",HttpStatus.ACCEPTED);
    }
    @PutMapping(value = "/update-food-details")
    public ResponseEntity updatefood(@RequestParam Integer foodId,@Valid @RequestBody Admin admin, @Valid @RequestBody FoodItem foodItem){
        List<FoodItem> foodItems = admin.getFoodItem();
        for(FoodItem food : foodItems){
            if(food.getFoodId()==foodId){
                food.setName(foodItem.getName());
                food.setDescription(foodItem.getDescription());
                return new ResponseEntity<>("Food data has been updated",HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("Fooditem with the following id has not been found",HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/getOrderbyorderid")
    public ResponseEntity orderget(@RequestParam Integer orderid){
        List<Admin> admins = adminService.getOrder();
        for(Admin admin : admins){
            List<Order> orders = admin.getOrderList();
            for(Order order : orders){
                if(order.getOrderId()==orderid){
                    return new ResponseEntity<>("Order has been found -"+order.getFoodId().getName(),HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>("the orderid has not been found please enter valid orderid",HttpStatus.BAD_REQUEST);
    }




}
