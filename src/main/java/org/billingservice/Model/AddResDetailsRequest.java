package org.billingservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;

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
