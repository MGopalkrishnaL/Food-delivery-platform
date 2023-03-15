package com.Geekster.MCT.Food.delivery.platform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String name;
    private String email;
    @JoinColumn(name = "list_of_orders")
    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> Orderid;

}
