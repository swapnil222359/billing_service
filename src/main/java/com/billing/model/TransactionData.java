package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "transaction_details")
public class TransactionData {

    @Id
    @Column(name = "trid", nullable = false)
    private int trID;

    @Column(name = "itemID",nullable = false)
    private int itemID;

    @Column(name = "quantity",nullable = false)
    private String qty;

}
