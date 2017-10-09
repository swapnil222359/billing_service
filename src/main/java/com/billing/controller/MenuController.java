package com.billing.controller;

import com.billing.model.Menu;
import com.billing.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(produces = "application/json", consumes = "application/json")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/{restaurantId}/menu")
    public List<Menu> getMenuDetails(@PathVariable("restaurantId") int restaurantId) {
        return menuService.getMenu(restaurantId);
    }

    @PostMapping(value = "/menu")
    public void saveMenu(@RequestBody Map<Integer, List<Menu>> restaurantMenuMap) {
        menuService.saveMenu(restaurantMenuMap);
    }

    @DeleteMapping(value = "/menu")
    public void deleteMenu(@RequestBody Map<Integer, List<Integer>> deleteMenuMap) {
        menuService.deleteMenu(deleteMenuMap);
    }

}
