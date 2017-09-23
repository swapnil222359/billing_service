package com.billing.repository;

import com.billing.model.Transaction;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sony on 20-09-2017.
 */
public interface TransactionDetailsRepository extends CrudRepository<Transaction,Integer> {

    Transaction save(Transaction transaction);
}
