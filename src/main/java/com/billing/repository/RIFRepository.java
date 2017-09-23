package com.billing.repository;

import com.billing.model.RestaurantDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RIFRepository extends CrudRepository<RestaurantDetails,Integer> {

    List<RestaurantDetails> findByName(String name);

    RestaurantDetails save (RestaurantDetails restaurantDetails);

    RestaurantDetails findByResID(int id);
}
