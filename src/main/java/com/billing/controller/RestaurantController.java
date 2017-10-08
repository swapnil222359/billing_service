package com.billing.controller;

import com.billing.model.AddResDetailsRequest;
import com.billing.model.ResDetailsAndMenu;
import com.billing.model.Restaurant;
import com.billing.model.RestaurantDetails;
import com.billing.service.MenuService;
import com.billing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping(value = "/restaurant")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
    }

    @GetMapping(value = "/restaurant/{restaurantId}")
    public ResponseEntity getRestaurantDetails(@PathVariable("restaurantId") int restaurantId) {
        Restaurant restaurant = restaurantService.getRestaurantDetails(restaurantId);
        ResponseEntity responseEntity = new ResponseEntity(restaurant, HttpStatus.OK);
        return responseEntity;
    }

}
