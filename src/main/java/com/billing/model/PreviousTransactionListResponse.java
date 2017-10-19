package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by sony on 12-10-2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PreviousTransactionListResponse {

    private int tableID;
    private int resID;
    private List<MenuItemsResponse> menuList;
}
