package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sony on 12-10-2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItemsResponse {

    private int  itemId;
    private String itemName;
    private String quantity;
    private int itemQuantity;
    private double price;
    private String type;
}
