package com.billing.service;

import com.billing.model.*;
import com.billing.repository.MenuRepository;
import com.billing.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class MenuService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    public void saveRIF(AddResDetailsRequest restaurantDetails) {
        restaurantRepository.save(restaurantDetails.getRestaurantDetails());
        LoginCredentials loginCredentials = LoginCredentials.builder()
                .loginID(restaurantDetails.getLoginID())
                .password(restaurantDetails.getPassword())
                .resID(restaurantDetails.getRestaurantDetails().getResID())
                .build();

    }

    public void saveMenu(List<Menu> restaurantMenuList) {
        restaurantMenuList.stream()
                .forEach(menu ->{
                    menuRepository.save(menu);
                });
    }

    public ResDetailsAndMenu getResMenu(int id) {
        List<Menu> itemList = getMenu(id);
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

    public List<Menu> getMenu(int resid) {
        return menuRepository.findByResid(resid);
    }

    public void deleteMenuItems(HashMap<Integer, List<Integer>> deleteMenuMap) {
        deleteMenuMap.entrySet().stream()
                .forEach(entry -> {
                    entry.getValue().stream()
                            .forEach(item -> {
                                Menu menu = Menu.builder()
                                        .itemID(item)
                                        .resid(entry.getKey())
                                        .build();

                                menuRepository.delete(menu);
                            });
                });
    }

    public List<Menu> getMenuListForMenuID(List<Integer>itemList){
        List<Menu>menuList =  new ArrayList<>();
        List<CompletableFuture<Menu>>futurelist = new ArrayList<>();

        itemList.stream().forEach(entry->
        {
            CompletableFuture<Menu> menu = menuRepository.findByItemID(entry);
            futurelist.add(menu);
        });

        for (CompletableFuture<Menu> item:futurelist) {
            try {
                menuList.add(item.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return menuList;
    }
}
