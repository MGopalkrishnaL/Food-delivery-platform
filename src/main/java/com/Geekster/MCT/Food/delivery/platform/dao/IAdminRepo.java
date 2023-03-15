package com.Geekster.MCT.Food.delivery.platform.dao;

import com.Geekster.MCT.Food.delivery.platform.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Integer> {

}
