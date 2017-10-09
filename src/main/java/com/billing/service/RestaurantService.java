package com.billing.service;

import com.billing.model.Restaurant;
import com.billing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void addRestaurant(Restaurant restaurant) {
        restaurant.getMenus().stream().forEach(menu -> menu.setRestaurant(restaurant));
        restaurant.getLogin().setRestaurant(restaurant);
        restaurantRepository.save(restaurant);
    }

    public Restaurant getRestaurantDetails(int restaurantId) {
        return restaurantRepository.findByRestaurantId(restaurantId);
    }
}
