package com.billing.repository;

import com.billing.model.Restaurant;
import com.billing.model.RestaurantDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {

    Restaurant findByRestaurantId(int restaurantId);

    Restaurant findByRestaurantName(String restaurantName);

    Restaurant save(Restaurant restaurant);

}
