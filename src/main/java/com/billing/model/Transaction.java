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
    @Column(name = "trID",nullable = false,unique = true)
    private int trID;

    @Column(name = "total" )
    private Double total;

    @Column(name = "resID" ,nullable = false)
    private int resID;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "userID")
    private Integer userID;

    @Column(name = "couponID")
    private Integer couponID;

    @Column(name = "tableID", nullable = false)
    private int tableID;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "paymentID")
    private String paymentID;
}
