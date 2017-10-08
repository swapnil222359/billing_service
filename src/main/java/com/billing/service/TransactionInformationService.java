package com.billing.service;

import com.billing.model.*;
import com.billing.repository.TableRepository;
import com.billing.repository.TransactionItemsRepository;
import com.billing.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by sony on 20-09-2017.
 */
@Service
public class TransactionInformationService {

    @Autowired
    private TransactionDetailsRepository tdRepository;

    @Autowired
    private TransactionItemsRepository itemsForTransactionRepository;

    @Autowired
    private TableRepository tableRepository;


    public Transaction saveTransactionDetails(TransactionDetailsRequest detailsRequest) {


        int listSize = detailsRequest.getItemQtyList().size();
        while(listSize-- > 0){
            Transaction transaction = Transaction.builder()
                    .resID(detailsRequest.getResID())
                    .timestamp(detailsRequest.getTimestamp())
                    .total(detailsRequest.getTotal())
                    .userID(detailsRequest.getUserID())
                    .couponID(detailsRequest.getCouponID())
                    .tableID(detailsRequest.getTableID())
                    .build();

            Transaction savedTransaction = tdRepository.save(transaction);
            removeTableTransactionData(detailsRequest);
            saveItemsForTransaction(detailsRequest,savedTransaction);
        }
        return null;
    }

    public void getTransactionDetails(TransactionDetailsRequest detailsRequest) {
        saveTransactionDetails(detailsRequest);
    }

    private void removeTableTransactionData(TransactionDetailsRequest transaction) {
        if(transaction.getTableID()!=null){
            tableRepository.deleteByTableIDAndResID(transaction.getTableID(),transaction.getResID());
        }
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

    public void saveTableTransactionData(TableDataRequest tableDataRequest) {
        tableDataRequest.getItemQtyList().entrySet().stream().forEach(entry->
                {
                    TableDetails details = TableDetails.builder()
                            .itemID(entry.getKey())
                            .quantity(entry.getValue())
                            .resID(tableDataRequest.getResID())
                            .tableID(tableDataRequest.getTableID())
                            .build();
                    tableRepository.save(details);
                }
        );
    }

    public TableTransactionResponse getTableDetails(int id, int resID) {
        List<TableDetails> detailsList = tableRepository.findByTableIDAndResID(id,resID);
        return tableDetailsResponse(detailsList);
    }

    private TableTransactionResponse tableDetailsResponse(List<TableDetails> detailsList) {
        TableTransactionResponse response =  new TableTransactionResponse();
        Map<Integer,String> itemList = detailsList.stream().collect(Collectors.toMap(TableDetails::getItemID,TableDetails::getQuantity));
        response.setResID(detailsList.get(0).getResID());
        response.setTableID(detailsList.get(0).getTableID());
        response.setItemQtyList(itemList);
        return response;
    }

}
