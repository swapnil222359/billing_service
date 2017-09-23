package org.billingservice.BillingController;

import org.billingservice.BillingServices.ResInfoAndMenuInfoService;
import org.billingservice.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sony on 16-09-2017.
 */
@RestController
public class RestaurantDetailsController {

    @Autowired
    private ResInfoAndMenuInfoService service;

    //for testing
    @RequestMapping(value = "/rest")
    String home(){

        RestaurantDetails restaurantDetails =  RestaurantDetails.builder()
                .name("angry")
                .address("address")
                .emailAddress("emadsf")
                .number(98989)
                .resID(123455)
                .build();
        AddResDetailsRequest detailsRequest = AddResDetailsRequest.builder()
                                            .restaurantDetails(restaurantDetails)
                                            .loginID("loginid")
                                            .password("passowrd")
                                            .build();

        service.saveRIF(detailsRequest);
        return "Hello ";
    }

    @RequestMapping(value = "/saveRestaurantDetails", method = RequestMethod.POST, consumes = "application/json")
    public void saveRIFDetails(@RequestBody AddResDetailsRequest restaurantDetails){
        service.saveRIF(restaurantDetails);
    }

   @RequestMapping(value = "/{id}/getRestaurantDetailsAndMenu", method = RequestMethod.GET, produces = "application/json")
   public ResDetailsAndMenu getResDetailsAndMenu(@PathVariable("id") int id){
       return service.getResMenu(id);
   }

}
