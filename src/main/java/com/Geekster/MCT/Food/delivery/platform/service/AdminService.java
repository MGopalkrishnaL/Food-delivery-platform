package com.Geekster.MCT.Food.delivery.platform.service;

import com.Geekster.MCT.Food.delivery.platform.dao.IAdminRepo;
import com.Geekster.MCT.Food.delivery.platform.dao.IFoodItemRepo;
import com.Geekster.MCT.Food.delivery.platform.model.Admin;
import com.Geekster.MCT.Food.delivery.platform.model.FoodItem;
import com.Geekster.MCT.Food.delivery.platform.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;
    @Autowired
    IFoodItemRepo foodItemRepo;
    public ResponseEntity savedata(Admin admin){
        adminRepo.save(admin);
        return new ResponseEntity<>("Save data", HttpStatus.CREATED);
    }
    public List<Admin> showAll(){
        return adminRepo.findAll();
    }
    public FoodItem findfood(int foodid){
        return foodItemRepo.findById(foodid).get();
    }

    public List<Admin> getadmins() {
        return adminRepo.findAll();
    }

    public List<FoodItem> findfoodItems() {
        return foodItemRepo.findAll();
    }
}
