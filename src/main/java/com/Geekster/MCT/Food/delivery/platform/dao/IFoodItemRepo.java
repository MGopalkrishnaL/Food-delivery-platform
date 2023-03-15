package com.Geekster.MCT.Food.delivery.platform.dao;


import com.Geekster.MCT.Food.delivery.platform.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem,Integer> {
}
