package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetailsRequest {

    private Map<Integer,Integer> itemQuantityMap;

    private double total;

    private int resID;

    private Timestamp timestamp;

    private int userID;

    private int couponID;

    private Integer tableID;

    private String type;

    private String paymentID;

}
