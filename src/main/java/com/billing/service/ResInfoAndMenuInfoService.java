package com.billing.service;

import com.billing.model.*;
import com.billing.repository.MIFRepository;
import com.billing.repository.RIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sony on 16-09-2017.
 */
@Service
public class ResInfoAndMenuInfoService {

    @Autowired
    private RIFRepository rifRepository;

    @Autowired
    private MIFRepository mifRepository;



    public void saveRIF(AddResDetailsRequest restaurantDetails){
        rifRepository.save(restaurantDetails.getRestaurantDetails());
        LoginCredentials loginCredentials = LoginCredentials.builder()
                                            .loginID(restaurantDetails.getLoginID())
                                            .password(restaurantDetails.getPassword())
                                            .resID(restaurantDetails.getRestaurantDetails().getResID())
                                            .build();
        //System.out.println(rifRepository.save(restaurantDetails));
        //System.out.println(rifRepository.findByName("Psycho@ad.com"));
    }

    public void saveMenu(MenuItemList menuItemList){
        for(MenuItems item: menuItemList.getItemsList()){
            MenuDetails details = MenuDetails.builder()
                                    .itemName(item.getItemName())
                                    .price(item.getPrice())
                                    .qty(item.getQty())
                                    .state(item.getState())
                                    .resid(menuItemList.getResID())
                                    .build();
            mifRepository.save(details);
        }
    }

    public ResDetailsAndMenu getResMenu(int id) {
        List<MenuDetails> itemList = getMenuListForRes(id);
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
        return rifRepository.findByResID(id);
    }

    public List<MenuDetails> getMenuListForRes(int resid) {
        return mifRepository.findByResid(resid);
    }

    public void deleteMenuItems(DeleteMenuItemsRequest menuItemList) {
        for(Integer itemID : menuItemList.getItem()){
            MenuDetails details = MenuDetails.builder()
                    .itemId(itemID)
                    .resid(menuItemList.getResid())
                    .build();
            mifRepository.delete(details);
        }
    }
}
