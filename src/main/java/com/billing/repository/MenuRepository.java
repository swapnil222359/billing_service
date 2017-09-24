package com.billing.repository;

import com.billing.model.Menu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu,String> {

    Menu save(Menu menu);

    List <Menu> findByResid(int id);

    void delete(Menu menuItem);
}
