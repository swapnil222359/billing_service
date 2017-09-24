package com.billing.service;

import com.billing.model.*;
import com.billing.repository.MenuRepository;
import com.billing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    public void saveRIF(AddResDetailsRequest restaurantDetails){
        restaurantRepository.save(restaurantDetails.getRestaurantDetails());
        LoginCredentials loginCredentials = LoginCredentials.builder()
                                            .loginID(restaurantDetails.getLoginID())
                                            .password(restaurantDetails.getPassword())
                                            .resID(restaurantDetails.getRestaurantDetails().getResID())
                                            .build();

    }

    public void saveMenu(HashMap<Integer, Menu> restaurantMenuMap){
        restaurantMenuMap.entrySet().stream().forEach(entry ->
            {
                entry.getValue().setResid(entry.getKey());
                menuRepository.save(entry.getValue());
            }
        );
    }

    public ResDetailsAndMenu getResMenu(int id) {
        List<Menu> itemList = getMenuListForRes(id);
        RestaurantDetails restaurantDetails = getRestaurantInformation(id);


        ResDetailsAndMenu resDetailsAndMenu = ResDetailsAndMenu.builder()
                                                .resID(restaurantDetails.getResID())
                                                .address(restaurantDetails.getAddress())
                                                .emailAddress(restaurantDetails.getEmailAddress())
                                                .contactNumber(restaurantDetails.getNumber())
                                                .menuDetails(itemList)
                                                .build();
        return resDetailsAndMenu;
    }

    private RestaurantDetails getRestaurantInformation(int id) {
        return restaurantRepository.findByResID(id);
    }

    public List<Menu> getMenuListForRes(int resid) {
        return menuRepository.findByResid(resid);
    }

    public void deleteMenuItems(HashMap<Integer, Menu> restaurantMenuMap) {
        restaurantMenuMap.entrySet().stream().forEach(entry ->
                {
                    entry.getValue().setResid(entry.getKey());
                    menuRepository.delete(entry.getValue());
                }
        );
    }
}
