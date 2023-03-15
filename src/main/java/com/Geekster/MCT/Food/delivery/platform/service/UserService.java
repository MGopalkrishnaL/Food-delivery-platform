package com.Geekster.MCT.Food.delivery.platform.service;

import com.Geekster.MCT.Food.delivery.platform.dao.IUserRepo;
import com.Geekster.MCT.Food.delivery.platform.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    public User addUser(User user) {
        return userRepo.save(user);
    }
    public List<User> getall() {
        return userRepo.findAll();
    }

}
