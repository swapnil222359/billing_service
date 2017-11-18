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

    @Column(name = "transaction_id", nullable = false)
    private int transactionId;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Menu menu;

    @Column(name = "item_quantity",nullable = false)
    private int itemQuantity;

}
