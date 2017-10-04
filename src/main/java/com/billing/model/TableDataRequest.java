package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Created by sony on 04-10-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableDataRequest {

    Map<Integer, String> itemQtyList;
    int resID;
    int tableID;
}
