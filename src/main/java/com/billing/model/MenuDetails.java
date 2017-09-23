package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sony on 18-09-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Menu")
public class MenuDetails implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "itemID", nullable = false)
    private int  itemId;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "qty", nullable = false)
    private String qty;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "resid", nullable = false)
    private int resid;
}
