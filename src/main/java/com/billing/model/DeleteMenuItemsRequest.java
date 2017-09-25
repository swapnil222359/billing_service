package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by sony on 24-09-2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteMenuItemsRequest {

    private int resid;
    private List<Integer> item;
}
