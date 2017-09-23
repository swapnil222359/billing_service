package com.billing.controller;

import com.billing.service.ResInfoAndMenuInfoService;
import com.billing.model.MenuDetails;
import com.billing.model.MenuItemList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

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
