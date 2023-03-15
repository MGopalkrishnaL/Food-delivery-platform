package com.Geekster.MCT.Food.delivery.platform.dao;

import com.Geekster.MCT.Food.delivery.platform.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IUserRepo extends JpaRepository<User,Integer> {


    List<User> findByName(String username);
}
