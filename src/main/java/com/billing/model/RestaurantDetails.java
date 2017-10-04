package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "rif")
public class RestaurantDetails implements Serializable {

    @Id
    @Column(name = "ResID",unique = true, nullable = false)
    private int resID;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Number",nullable = false)
    private int number;

    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name = "EmailID",nullable = false)
    private String emailAddress;

    @Column(name = "loginID",nullable = false)
    private String loginID;

    @Column(name = "password",nullable = false)
    private String password;

}
