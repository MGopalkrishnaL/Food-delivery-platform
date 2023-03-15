package com.Geekster.MCT.Food.delivery.platform.service;

import com.Geekster.MCT.Food.delivery.platform.dao.IUserRepo;
import com.Geekster.MCT.Food.delivery.platform.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public JSONObject login (String username, String password) {
        JSONObject response = new JSONObject();
        List<User> user = userRepo.findByName(username);
        if(user.isEmpty()) {
            response.put("errorMessage", "username doesn't exist");
        }else {
            User userObj = user.get(0);
            if(password.equals(userObj.getEmail())) {
                response = create(userObj);
            }else {
                response.put("errorMessage" , "password is not valid");
            }
        }
        return response;
    }
    public JSONObject create(User user){
        JSONObject json = new JSONObject();
        json.put("userId",user.getUserId());
        json.put("name",user.getName());
        json.put("email",user.getEmail());
        return json;
    }


}
