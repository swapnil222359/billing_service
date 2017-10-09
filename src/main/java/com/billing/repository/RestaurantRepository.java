package com.billing.repository;

import com.billing.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    Restaurant findByRestaurantId(int restaurantId);

    Restaurant findByRestaurantName(String restaurantName);

    Restaurant save(Restaurant restaurant);

}
