package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by sony on 21-09-2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItemList {

    private int resID;
    private List<MenuItems> itemsList;
}
