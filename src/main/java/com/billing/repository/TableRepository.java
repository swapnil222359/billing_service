package com.billing.repository;

import com.billing.model.TableDetails;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sony on 04-10-2017.
 */
public interface TableRepository extends CrudRepository<TableDetails,Integer> {
    TableDetails save(TableDetails details);

    List<TableDetails> deleteByTableIDAndResID(int tableID, int resID);

    List<TableDetails> findByTableIDAndResID(int tableID, int resID);
}
