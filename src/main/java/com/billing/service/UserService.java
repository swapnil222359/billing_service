package com.billing.service;

import com.billing.model.User;
import com.billing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(int restaurantId) {
        return userRepository.findByResid(restaurantId);
    }
}
