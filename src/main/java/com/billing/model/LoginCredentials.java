package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "login_details")
public class LoginCredentials {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "srNum",nullable = false)
    private int serialNumber;

    @Column(name = "loginID",nullable = false)
    private String loginID;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "ResID", nullable = false)
    private int resID;
}

