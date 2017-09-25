package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by sony on 19-09-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetailsRequest {

    private Map<Integer,String> itemQtyList;

    private double total;

    private int resID;

    private Timestamp timestamp;

   // private int userID;

}
