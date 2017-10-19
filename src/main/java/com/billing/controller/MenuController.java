package com.billing.controller;

import com.billing.model.Menu;
import com.billing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(produces = "application/json", consumes = "application/json")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "/saveMenu")
    public void saveDetails(@RequestBody List<Menu> restaurantMenuMap) {
        menuService.saveMenu(restaurantMenuMap);
    }

    @GetMapping(value = "/{id}/getMenu")
    public List<Menu> getMenuDetails(@PathVariable("id") int id) {
        return menuService.getMenu(id);
    }

    @PostMapping(value = "/deleteMenuItem")
    public void deleteMenuItems(@RequestBody HashMap<Integer, List<Integer>> deleteMenuMap) {
        menuService.deleteMenuItems(deleteMenuMap);
    }


}
