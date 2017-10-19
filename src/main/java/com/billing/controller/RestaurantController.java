package com.billing.controller;

import com.billing.model.AddResDetailsRequest;
import com.billing.model.ResDetailsAndMenu;
import com.billing.model.RestaurantDetails;
import com.billing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private MenuService service;

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

    @RequestMapping(value = "/get")
    String hello(){
        return "helloworld";
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
