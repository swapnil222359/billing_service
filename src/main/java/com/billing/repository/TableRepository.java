package com.billing.repository;

import com.billing.model.TableDetailsPK;
import com.billing.model.TableDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sony on 04-10-2017.
 */
public interface TableRepository extends CrudRepository<TableDetails,TableDetailsPK> {

    TableDetails save(TableDetails details);

    @Modifying
    @Transactional
    @Async
    void deleteByDetailsID_TableIdAndDetailsID_RestaurantId(int tableId, int restaurantId);

    List<TableDetails> findByDetailsID_TableIdAndDetailsID_RestaurantId(int tableId,int restaurantId);
    //List<TableDetails> findByResID(int tableID, int resID);

}
