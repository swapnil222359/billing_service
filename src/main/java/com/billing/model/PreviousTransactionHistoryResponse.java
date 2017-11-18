package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Created by sony on 12-10-2017.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PreviousTransactionHistoryResponse {
    private int transactionId;
    private Double total;
    private int restaurantId;
    private Integer userId;
    private Integer couponId;
    private int tableId;
    private Timestamp timestamp;
    private String paymentType;
    private String paymentId;
}
