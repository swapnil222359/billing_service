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
@Table(name = "transaction_details")
public class TransactionData {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "Id",nullable = false, unique = true)
    private int id;

    @Column(name = "trID", nullable = false)
    private int trID;

    @Column(name = "itemID",nullable = false)
    private int itemID;

    @Column(name = "quantity",nullable = false)
    private int qty;

}
