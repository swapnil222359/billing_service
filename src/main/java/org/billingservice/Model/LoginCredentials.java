package org.billingservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by sony on 23-09-2017.
 */
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

