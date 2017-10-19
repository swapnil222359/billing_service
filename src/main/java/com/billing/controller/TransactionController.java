package com.billing.controller;

import com.billing.model.PreviousTransactionListResponse;
import com.billing.model.TableDataRequest;
import com.billing.model.TableTransactionResponse;
import com.billing.service.TransactionInformationService;
import com.billing.model.TransactionDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        transactionInformationService.getTransactionDetails(detailsRequest);
    }

    @PostMapping(value = "/savetabledata")
    public void saveTableTransaction(@RequestBody TableDataRequest tableDataRequest){
        transactionInformationService.saveTableTransactionData(tableDataRequest);
    }

    @GetMapping(value = "/gettabledetails/{total}/res/{resID}")
    public TableTransactionResponse getTableTransactionDetails(@PathVariable(value = "tableID")int id, @PathVariable(value = "resID")int resID){
        return transactionInformationService.getTableDetails(id,resID);
    }

    @GetMapping(value = "/previoustransactions/{total}/res/{resID}")
    public PreviousTransactionListResponse getPreviousTransactions(@PathVariable(value = "total")int total,@PathVariable(value = "resID")int resID){
        return transactionInformationService.getPreviousTransactions(total,resID);
    }



   // public void updateTransaction()
}
