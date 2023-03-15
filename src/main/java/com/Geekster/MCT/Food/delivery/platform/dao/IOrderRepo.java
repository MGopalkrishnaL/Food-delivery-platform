package com.Geekster.MCT.Food.delivery.platform.dao;

import com.Geekster.MCT.Food.delivery.platform.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IOrderRepo extends JpaRepository<Order,Integer> {
    @Query(value = "select * from order_tbl where userid_user_id = :userid",nativeQuery = true)
    public List<Order> getOrdersList(Integer userid);
    @Query(value = "select * from order_tbl where userid_user_id = :userid and food_id = :foodid",nativeQuery = true)
    public List<Order> getOrderList(int userid,int foodid);

}
