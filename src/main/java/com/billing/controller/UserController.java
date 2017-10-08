package com.billing.controller;

import com.billing.model.User;
import com.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{restaurantId}/users")
    public List<User> getUsers(@PathVariable ("restaurantId") int restaurantId) {
        return userService.getUsers(restaurantId);
    }

}
