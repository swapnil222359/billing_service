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
    @Column(name = "transactionId",nullable = false,unique = true)
    private int transactionId;

    @Column(name = "total" )
    private Double total;

    @Column(name = "restaurantId" ,nullable = false)
    private int restaurantId;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "couponId")
    private Integer couponId;

    @Column(name = "tableId", nullable = false)
    private int tableId;

    @Column(name = "payment_type")
    private String paymentType;

    @Column(name = "paymentId")
    private String paymentId;
}
