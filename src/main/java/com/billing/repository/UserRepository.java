package com.billing.repository;

import com.billing.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,String>  {

    User save(User user);

    List<User> findByRestaurantId(int id);

}
