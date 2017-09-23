package org.billingservice.Repository;

import org.billingservice.Model.RestaurantDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sony on 16-09-2017.
 */
public interface RIFRepository extends CrudRepository<RestaurantDetails,Integer> {

    List<RestaurantDetails> findByName(String name);

    RestaurantDetails save (RestaurantDetails restaurantDetails);

    RestaurantDetails findByResID(int id);
}
