package com.Geekster.MCT.Food.delivery.platform.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_tbl")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @Length(min = 5,max = 20,message = "The length of username should be 3 to 20 characters")
    private String username;
    @Length(min = 5,max = 20,message = "The length of username should be 3 to 20 characters")
    private String password;
    @Email(message = "enter valid email")
    private String email;
    @Digits(integer = 10,fraction = 0,message = "please eneter the 10 digits number")
    private String phonenumber;
    @JoinColumn(name = "foodId")
    @OneToMany(fetch = FetchType.LAZY)
    private List<FoodItem> foodItem;
    @JoinColumn(name = "orderId")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Order>  orderList;

}
