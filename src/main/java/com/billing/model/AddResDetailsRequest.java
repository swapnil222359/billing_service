package com.billing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sony on 23-09-2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddResDetailsRequest {

    private RestaurantDetails restaurantDetails;
    private String loginID;
    private String password;
}
