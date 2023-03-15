package com.Geekster.MCT.Food.delivery.platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @JoinColumn(name = "food_id")
    @OneToOne
    private FoodItem foodId;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userid;

}
