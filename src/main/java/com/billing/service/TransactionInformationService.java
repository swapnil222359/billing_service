package com.billing.service;

import com.billing.model.*;
import com.billing.repository.TableRepository;
import com.billing.repository.TransactionItemsRepository;
import com.billing.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
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

    @Autowired
    private MenuService menuService;


    public Transaction saveTransactionDetails(TransactionDetailsRequest detailsRequest) {

        Transaction transaction = Transaction.builder()
                .resID(detailsRequest.getResID())
                .timestamp(detailsRequest.getTimestamp())
                .total(detailsRequest.getTotal())
                .userID(detailsRequest.getUserID())
                .couponID(detailsRequest.getCouponID())
                .tableID(detailsRequest.getTableID())
                .paymentType(detailsRequest.getType())
                .paymentID(detailsRequest.getPaymentID())
                .build();

        Transaction savedTransaction = tdRepository.save(transaction);

        removeTableTransactionData(detailsRequest);

        saveItemsForTransaction(detailsRequest,savedTransaction);

        return transaction;
    }

    public void getTransactionDetails(TransactionDetailsRequest detailsRequest) {
        saveTransactionDetails(detailsRequest);
    }

    private void removeTableTransactionData(TransactionDetailsRequest transaction) {
        if(transaction.getTableID()!=null){
            tableRepository.deleteByDetailsID_TableIDAndDetailsID_ResID(3,1);
        }
    }

    private void saveItemsForTransaction(TransactionDetailsRequest detailsRequest, Transaction savedTransaction) {

        for(Map.Entry<Integer,Integer> item:detailsRequest.getItemQuantityMap().entrySet()){
            TransactionData transaction = TransactionData.builder()
                    .itemID(item.getKey())
                    .qty(item.getValue())
                    .trID(savedTransaction.getTrID())
                    .build();

            itemsForTransactionRepository.save(transaction);
        }
    }

    public void saveTableTransactionData(TableDataRequest tableDataRequest) {
        tableDataRequest.getItemQuantityMap().entrySet().stream().forEach(entry->
                {
                    TableDetails details = TableDetails.builder()
                            .detailsID(TdetailsID.builder()
                                    .itemID(entry.getKey())
                                    .resID(tableDataRequest.getResID())
                                    .tableID(tableDataRequest.getTableID())
                                    .build()
                            )
                            .quantity(entry.getValue())
                            .build();
                    tableRepository.save(details);
                }
        );
    }

    public TableTransactionResponse getTableDetails(int id, int resID) {
        List<TableDetails> detailsList = tableRepository.findByDetailsID_TableIDAndDetailsID_ResID(id,resID);

        List<Integer> itemIDList = null;
        Map<Integer,Integer> itemQtyList =  new HashMap<>();
        List<Menu> menuList = null;
        if(detailsList != null && !detailsList.isEmpty()){
            itemIDList = detailsList.stream().map(item -> item.getDetailsID().getItemID()).collect(Collectors.toList());
            itemQtyList = detailsList.stream().collect(Collectors.toMap(item-> item.getDetailsID().getItemID(),TableDetails::getQuantity));
            menuList = menuService. getMenuListForMenuID(itemIDList);
        }
        return getTableDetailsResponse(menuList,id,resID,itemQtyList);
    }

    private TableTransactionResponse getTableDetailsResponse(List<Menu> menuList, int tableID, int resID, Map<Integer, Integer> itemQtyList) {

        List<MenuItemsResponse> menuItemsResponseList = menuList.stream()
                .filter(item->itemQtyList.containsKey(item.getItemID()))
                .map(menuItem ->{

                     return MenuItemsResponse.builder()
                            .itemId(menuItem.getItemID())
                            .itemName(menuItem.getItemName())
                            .price(menuItem.getPrice())
                            .type(menuItem.getType())
                            .quantity(menuItem.getQty())
                            .itemQuantity(itemQtyList.get(menuItem.getItemID()))
                            .build();
                }).collect(Collectors.toList());

        TableTransactionResponse response = TableTransactionResponse.builder()
                .resID(resID)
                .tableID(tableID)
                .itemList(menuItemsResponseList)
                .build();
        return response;
    }

    public List<PreviousTransactionHistoryResponse> getPreviousTransactions(int resID, int count, int page) {
        Pageable pageCount = new PageRequest(page,count);
        List<Transaction> transactionList = tdRepository.findByResIDOrderByTrIDDesc(resID,pageCount);

        return translatedResponseFromTransaction(transactionList);
    }

    private List<PreviousTransactionHistoryResponse> translatedResponseFromTransaction(List<Transaction> transactionList) {
        List<PreviousTransactionHistoryResponse> responseList = new ArrayList<>();
        transactionList.stream().forEach(item->{
            responseList.add(PreviousTransactionHistoryResponse.builder()
                    .resID(item.getResID())
                    .tableID(item.getTableID())
                    .couponID(item.getCouponID())
                    .trID(item.getTrID())
                    .paymentID(item.getPaymentID())
                    .paymentType(item.getPaymentType())
                    .total(item.getTotal())
                    .userID(item.getUserID())
                    .timestamp(item.getTimestamp())
                    .build()
            );
        });
        return responseList;
    }

    public TableTransactionResponse getCompletedTransaction(int trID) {
        return new TableTransactionResponse();
    }
}
