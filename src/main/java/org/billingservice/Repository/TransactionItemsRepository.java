package org.billingservice.Repository;

import org.billingservice.Model.TransactionData;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sony on 20-09-2017.
 */
public interface TransactionItemsRepository extends CrudRepository<TransactionData,Integer> {

    TransactionData save(TransactionData data);
}
