package org.billingservice.BillingServices;

import org.billingservice.Model.Transaction;
import org.billingservice.Model.TransactionData;
import org.billingservice.Model.TransactionDetailsRequest;
import org.billingservice.Repository.TransactionItemsRepository;
import org.billingservice.Repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sony on 20-09-2017.
 */
@Service
public class TransactionInformationService {

    @Autowired
    private TransactionDetailsRepository tdRepository;

    @Autowired
    private TransactionItemsRepository itemsForTransactionRepository;

    public Transaction saveTransactionDetails(TransactionDetailsRequest detailsRequest) {


        int listSize = detailsRequest.getItemQtyList().size();
        while(listSize-- > 0){
            Transaction transaction = Transaction.builder()
                    .resID(detailsRequest.getResID())
                    .date(detailsRequest.getDate())
                    .time(detailsRequest.getTime())
                    .total(detailsRequest.getTotal())
                    //.userID(detailsRequest.getUserID())
                    .build();

            Transaction savedTransaction = tdRepository.save(transaction);
            saveItemsForTransaction(detailsRequest,savedTransaction);
        }
        return null;
    }

    public void getTransactionDetails(TransactionDetailsRequest detailsRequest) {
        saveTransactionDetails(detailsRequest);
    }

    private void saveItemsForTransaction(TransactionDetailsRequest detailsRequest, Transaction savedTransaction) {

        for(Map.Entry<Integer,String> item:detailsRequest.getItemQtyList().entrySet()){
            TransactionData transaction = TransactionData.builder()
                    .itemID(item.getKey())
                    .qty(item.getValue())
                    .trID(savedTransaction.getTrID())
                    .build();

            itemsForTransactionRepository.save(transaction);
        }
    }

}
