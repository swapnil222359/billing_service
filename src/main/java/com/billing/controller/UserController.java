package com.billing.controller;

import com.billing.model.User;
import com.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/saveuser")
    public int saveUser(User user){
        return userService.saveUser(user);
    }

}
