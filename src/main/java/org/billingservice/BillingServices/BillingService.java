package org.billingservice.BillingServices;

import org.billingservice.Model.RestaurantDetails;
import org.billingservice.Repository.RIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sony on 16-09-2017.
 */
@Service
public class BillingService {

    @Autowired
    private RIFRepository rifRepository;

    public void saveRIF(RestaurantDetails restaurantDetails){
        System.out.println(rifRepository.findByName(restaurantDetails.getName()));
    }
}
