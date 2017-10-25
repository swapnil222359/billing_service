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
    private int trID;
    private Double total;
    private int resID;
    private Integer userID;
    private Integer couponID;
    private int tableID;
    private Timestamp timestamp;
    private String paymentType;
    private String paymentID;
}
