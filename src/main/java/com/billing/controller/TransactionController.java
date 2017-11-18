package com.billing.controller;

import com.billing.model.PreviousTransactionHistoryResponse;
import com.billing.model.TableDataRequest;
import com.billing.model.TableTransactionResponse;
import com.billing.service.TransactionInformationService;
import com.billing.model.TransactionDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sony on 20-09-2017.
 */
@RestController
@RequestMapping(produces = "application/json", consumes = "application/json")
public class TransactionController {

    @Autowired
    private TransactionInformationService transactionInformationService;

    @PostMapping(value = "/savetransaction")
    public void saveTransactionDetails(@RequestBody TransactionDetailsRequest detailsRequest){
        transactionInformationService.saveTransactionDetails(detailsRequest);
    }

    @PostMapping(value = "/savetabledata")
    public void saveTableTransaction(@RequestBody TableDataRequest tableDataRequest){
        transactionInformationService.saveTableTransactionData(tableDataRequest);
    }

    @GetMapping(value = "/gettabledetails/{total}/res/{resID}")
    public TableTransactionResponse getTableTransactionDetails(@PathVariable(value = "tableID")int tableId, @PathVariable(value = "resID")int restaurantId){
        return transactionInformationService.getTableDetails(tableId,restaurantId);
    }

    @GetMapping(value = "/previoustransactions/res/{resID}/{count}/{page}")
    public List<PreviousTransactionHistoryResponse> getPreviousTransactions(@PathVariable(value = "resID")int restaurantId, @PathVariable(value = "count")int count, @PathVariable(value = "page")int page){
        return transactionInformationService.getPreviousTransactions(restaurantId,count,page);
    }

    @GetMapping(value = "/previoustransactions/res/{resID}/{transactionID}")
    public TableTransactionResponse getTransactionForID(@PathVariable(value = "resID")int restaurantId ,@PathVariable(value = "transactionID")int transactionId){
        return transactionInformationService.getCompletedTransaction(transactionId,restaurantId);
    }



   // public void updateTransaction()
}
