package com.billing.translator;

import com.billing.model.Menu;
import com.billing.model.MenuItemsResponse;

/**
 * Created by sony on 29-10-2017.
 */
public class MenuTranslator {

    public static MenuItemsResponse translateMenuItem(Menu menu , int itemQuantity){
        MenuItemsResponse response = MenuItemsResponse.builder()
                .itemId(menu.getItemId())
                .itemName(menu.getItemName())
                .price(menu.getPrice())
                .quantity(menu.getQuantity())
                .type(menu.getType())
                .itemQuantity(itemQuantity)
                .build();
        return response;
    }
}
