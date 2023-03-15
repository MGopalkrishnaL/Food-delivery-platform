package com.Geekster.MCT.Food.delivery.platform.dao;

import com.Geekster.MCT.Food.delivery.platform.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestaurantRepo extends JpaRepository<Restaurant,Integer> {

}
