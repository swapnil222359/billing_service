package org.billingservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sony on 19-09-2017.
 */
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

    @Column(name = "qty",nullable = false)
    private String qty;

}
