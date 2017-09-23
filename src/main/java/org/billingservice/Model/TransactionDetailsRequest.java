package org.billingservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;

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

    private Date date;

    private Time time;

   // private int userID;

}
