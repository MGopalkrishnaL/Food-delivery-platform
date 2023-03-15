package com.Geekster.MCT.Food.delivery.platform.dao;

import com.Geekster.MCT.Food.delivery.platform.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrderRepo extends JpaRepository<Order,Integer> {
}
