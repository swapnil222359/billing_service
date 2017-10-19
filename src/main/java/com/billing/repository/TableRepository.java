package com.billing.repository;

import com.billing.model.TdetailsID;
import com.billing.model.TableDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sony on 04-10-2017.
 */
public interface TableRepository extends CrudRepository<TableDetails,TdetailsID> {

    TableDetails save(TableDetails details);

    @Modifying
    @Transactional
    @Async
    void deleteByDetailsID_TableIDAndDetailsID_ResID(int tableID, int resID);

    List<TableDetails> findByDetailsID_TableIDAndDetailsID_ResID(int tableID,int resID);
    //List<TableDetails> findByResID(int tableID, int resID);

}
