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

    private int restaurantId;

    private Timestamp timestamp;

    private int userId;

    private int couponId;

    private Integer tableId;

    private String type;

    private String paymentId;

}
