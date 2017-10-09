package com.billing.service;

import com.billing.model.Menu;
import com.billing.model.Restaurant;
import com.billing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    public void saveMenu(Map<Integer, List<Menu>> restaurantMenuMap) {
        Optional<Map.Entry<Integer, List<Menu>>> entry = restaurantMenuMap.entrySet()
                .stream()
                .findFirst();

        Integer restaurantId = entry.isPresent() ? entry.get().getKey() : null;
        List<Menu> menuList = entry.isPresent() ? entry.get().getValue() : null;

        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        menuList.stream().forEach(menu -> menu.setRestaurant(restaurant));
        restaurant.getMenus().addAll(menuList);
        restaurantRepository.save(restaurant);
    }

    public List<Menu> getMenu(int restaurantId) {
        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);
        return restaurant.getMenus();
    }

    public void deleteMenu(Map<Integer, List<Integer>> deleteMenuMap) {
        Optional<Map.Entry<Integer, List<Integer>>> entry = deleteMenuMap.entrySet()
                .stream()
                .findFirst();

        Integer restaurantId = entry.isPresent() ? entry.get().getKey() : null;
        List<Integer> itemList = entry.isPresent() ? entry.get().getValue() : null;

        Restaurant restaurant = restaurantRepository.findByRestaurantId(restaurantId);

        itemList.stream().forEach(item -> {
            restaurant.getMenus().stream()
                    .filter(menu -> menu.getItemId() == item)
                    .findFirst()
                    .map(menu -> restaurant.getMenus().remove(menu));
        });

        restaurantRepository.save(restaurant);
    }
}
