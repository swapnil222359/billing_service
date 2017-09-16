package org.billingservice.BillingController;

import org.billingservice.BillingServices.BillingService;
import org.billingservice.Model.RestaurantDetails;
import org.billingservice.ServiceStarter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sony on 16-09-2017.
 */
@RestController
public class RestaurantDetailsController {

    @Autowired
    private BillingService service;

    @RequestMapping(value = "/rest")
    String home(){
        RestaurantDetails restaurantDetails = new RestaurantDetails();
        restaurantDetails.setName("angry");
        restaurantDetails.setAddress("address");
        restaurantDetails.setNumber(1234);
        restaurantDetails.setEmailAddress("emailaddress");
        service.saveRIF(restaurantDetails);
        return "Hello ";
    }
}
