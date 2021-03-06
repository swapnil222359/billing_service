package com.billing.repository;

import com.billing.model.TransactionData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by sony on 20-09-2017.
 */
public interface TransactionItemsRepository extends CrudRepository<TransactionData,Integer> {

    TransactionData save(TransactionData data);

    List<TransactionData> findByTransactionId(int transactionID);
}
