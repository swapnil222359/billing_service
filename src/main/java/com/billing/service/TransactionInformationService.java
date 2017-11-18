package com.billing.service;

import com.billing.model.*;
import com.billing.repository.TableRepository;
import com.billing.repository.TransactionItemsRepository;
import com.billing.repository.TransactionDetailsRepository;
import com.billing.translator.MenuTranslator;
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
                .restaurantId(detailsRequest.getRestaurantId())
                .timestamp(detailsRequest.getTimestamp())
                .total(detailsRequest.getTotal())
                .userId(detailsRequest.getUserId())
                .couponId(detailsRequest.getCouponId())
                .tableId(detailsRequest.getTableId())
                .paymentType(detailsRequest.getType())
                .paymentId(detailsRequest.getPaymentId())
                .build();

        Transaction savedTransaction = tdRepository.save(transaction);

        removeTableTransactionData(detailsRequest);

        saveItemsForTransaction(detailsRequest,savedTransaction);

        return transaction;
    }

    private void removeTableTransactionData(TransactionDetailsRequest transaction) {
        if(transaction.getTableId()!=null){
            tableRepository.deleteByDetailsID_TableIdAndDetailsID_RestaurantId(3,1);
        }
    }

    private void saveItemsForTransaction(TransactionDetailsRequest detailsRequest, Transaction savedTransaction) {

        for(Map.Entry<Integer,Integer> item:detailsRequest.getItemQuantityMap().entrySet()){
            Menu menu = Menu.builder()
                    .itemId(item.getKey())
                    .build();
            TransactionData transaction = TransactionData.builder()
                    .menu(menu)
                    .itemQuantity(item.getValue())
                    .transactionId(savedTransaction.getTransactionId())
                    .build();

            itemsForTransactionRepository.save(transaction);
        }
    }

    public void saveTableTransactionData(TableDataRequest tableDataRequest) {
        tableDataRequest.getItemQuantityMap().entrySet().stream().forEach(entry->
                {
                    TableDetails details = TableDetails.builder()
                            .detailsID(TableDetailsPK.builder()
                                    .itemId(entry.getKey())
                                    .restaurantId(tableDataRequest.getRestaurantId())
                                    .tableId(tableDataRequest.getTableId())
                                    .build()
                            )
                            .quantity(entry.getValue())
                            .build();
                    tableRepository.save(details);
                }
        );
    }

    public TableTransactionResponse getTableDetails(int id, int resID) {
        List<TableDetails> detailsList = tableRepository.findByDetailsID_TableIdAndDetailsID_RestaurantId(id,resID);

        List<Integer> itemIDList = null;
        Map<Integer,Integer> itemQtyList =  new HashMap<>();
        List<Menu> menuList = null;
        if(detailsList != null && !detailsList.isEmpty()){
            itemIDList = detailsList.stream().map(item -> item.getDetailsID().getItemId()).collect(Collectors.toList());
            itemQtyList = detailsList.stream().collect(Collectors.toMap(item-> item.getDetailsID().getItemId(),TableDetails::getQuantity));
            menuList = menuService. getMenuListForMenuID(itemIDList);
        }
        return getTableDetailsResponse(menuList,id,resID,itemQtyList);
    }

    private TableTransactionResponse getTableDetailsResponse(List<Menu> menuList, int tableID, int resID, Map<Integer, Integer> itemQtyList) {

        List<MenuItemsResponse> menuItemsResponseList = menuList.stream()
                .filter(item->itemQtyList.containsKey(item.getItemId()))
                .map(menuItem -> MenuTranslator.translateMenuItem(menuItem,itemQtyList.get(menuItem.getItemId()))).collect(Collectors.toList());

        TableTransactionResponse response = TableTransactionResponse.builder()
                .restaurantId(resID)
                .tableId(tableID)
                .itemList(menuItemsResponseList)
                .build();
        return response;
    }

    public List<PreviousTransactionHistoryResponse> getPreviousTransactions(int restaurantId, int count, int page) {
        Pageable pageCount = new PageRequest(page,count);
        List<Transaction> transactionList = tdRepository.findByRestaurantIdOrderByTransactionIdDesc(restaurantId,pageCount);

        return translatedResponseFromTransaction(transactionList);
    }

    private List<PreviousTransactionHistoryResponse> translatedResponseFromTransaction(List<Transaction> transactionList) {
        List<PreviousTransactionHistoryResponse> responseList = new ArrayList<>();
        transactionList.stream().forEach(item->{
            responseList.add(PreviousTransactionHistoryResponse.builder()
                    .restaurantId(item.getRestaurantId())
                    .tableId(item.getTableId())
                    .couponId(item.getCouponId())
                    .transactionId(item.getTransactionId())
                    .paymentId(item.getPaymentId())
                    .paymentType(item.getPaymentType())
                    .total(item.getTotal())
                    .userId(item.getUserId())
                    .timestamp(item.getTimestamp())
                    .build()
            );
        });
        return responseList;
    }

    public TableTransactionResponse getCompletedTransaction(int transactionId,int restaurantId) {
        List<TransactionData> list = itemsForTransactionRepository.findByTransactionId(transactionId);
        List<MenuItemsResponse> menuItemsResponseList = list.stream().map(item-> MenuTranslator.translateMenuItem(item.getMenu(),item.getItemQuantity())).collect(Collectors.toList());

        return TableTransactionResponse.builder()
                .itemList(menuItemsResponseList)
                .restaurantId(restaurantId)
                .build();
    }
}
