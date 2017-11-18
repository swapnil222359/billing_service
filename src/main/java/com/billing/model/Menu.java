package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id", nullable = false)
    private int  itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "type")
    private String type;

    @Column(name = "restaurant_id", nullable = false)
    private int restaurantId;

}
