package org.billingservice.Repository;

import org.billingservice.Model.MenuDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sony on 18-09-2017.
 */
public interface MIFRepository extends CrudRepository<MenuDetails,String> {

    MenuDetails save(MenuDetails menuDetails);

    List <MenuDetails> findByResid(int id);

    void delete(MenuDetails menuItem);
}
