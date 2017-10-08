package com.billing.service;

import com.billing.model.Menu;
import com.billing.model.Restaurant;
import com.billing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void saveMenu(Map<Integer, List<Menu>> restaurantMenuMap) {
        restaurantMenuMap.entrySet().stream().forEach(entry ->
                {
                    Restaurant restaurant = restaurantRepository.findByRestaurantId(entry.getKey());
                    entry.getValue().stream().forEach(menu -> menu.setRestaurant(restaurant));
                    restaurant.getMenus().addAll(entry.getValue());
                    restaurantRepository.save(restaurant);
                }
        );
    }

    public List<Menu> getMenu(int restaurantId) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        return restaurant.getMenus();
    }

}
