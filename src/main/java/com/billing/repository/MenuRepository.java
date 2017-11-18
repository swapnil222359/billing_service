package com.billing.repository;

import com.billing.model.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface MenuRepository extends CrudRepository<Menu,String> {

    Menu save(Menu menu);

    List <Menu> findByRestaurantId(int restaurantId);

    void delete(Menu menuItem);

    @Async
    CompletableFuture<Menu> findByItemId(int id);
}
