package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "trid",nullable = false,unique = true)
    private int trID;

    @Column(name = "total" ,nullable = false)
    private double total;

    @Column(name = "resid" ,nullable = false)
    private int resID;

    @Column(name = "timestamp",nullable = false)
    private Timestamp timestamp;

    @Column(name = "userid", nullable = false)
    private int userID;

    @Column(name = "couponID", nullable = false)
    private String couponID;

    @Column(name = "tableID", nullable = false)
    private int tableID;
}
