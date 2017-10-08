package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "restaurant_id", unique = true, nullable = false)
    private int restaurantId;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "phone_number", nullable = false)
    private BigInteger phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "email_id", nullable = false)
    private String emailId;

    @Column(name = "table_count", nullable = false)
    private int tableCount;

    @OneToOne(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Login login;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> menus;

}
