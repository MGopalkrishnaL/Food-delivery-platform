package com.Geekster.MCT.Food.delivery.platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int restaurantId;
    @Length(min = 3,max = 20,message = "The restaurant length should be between 3 to 20 characters")
    private String name;
    @Length(min = 3,max = 50,message = "The restaurant Address should be between 3 to 50 characters")
    private String address;

    @OneToMany
    private List<FoodItem> foodItemsList;

}
