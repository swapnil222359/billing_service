package org.billingservice.BillingController;

import org.billingservice.BillingServices.ResInfoAndMenuInfoService;
import org.billingservice.Model.MenuDetails;
import org.billingservice.Model.MenuItemList;
import org.billingservice.Repository.MIFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sony on 21-09-2017.
 */
public class MenuController {

    @Autowired
    private ResInfoAndMenuInfoService menuService;

    @RequestMapping(value = "/saveMenu", method = RequestMethod.POST, consumes = "application/json")
    public void saveDetails(@RequestBody MenuItemList menuItemList){
        menuService.saveMenu(menuItemList);
    }

    @RequestMapping(value = "/{id}/getMenu", method = RequestMethod.GET, produces = "application/json")
    public List<MenuDetails> getMenuDetails(@PathVariable("id") int id){

        return menuService.getMenuListForRes(id);
    }

    @RequestMapping(value = "/deleteMenuItem", method = RequestMethod.POST, consumes = "application/json")
    public void deleteMenuItems(@RequestBody MenuItemList menuItemList){
        menuService.deleteMenuItems(menuItemList);
    }


}
