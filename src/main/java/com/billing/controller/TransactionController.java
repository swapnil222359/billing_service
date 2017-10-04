package com.billing.controller;

import com.billing.model.TableDataRequest;
import com.billing.model.TableTransactionResponse;
import com.billing.service.TransactionInformationService;
import com.billing.model.TransactionDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sony on 20-09-2017.
 */
@RestController
public class TransactionController {

    @Autowired
    private TransactionInformationService transactionInformationService;

    @RequestMapping(value = "/savetransaction",  method = RequestMethod.POST, consumes = "application/json")
    public void saveTransactionDetails(TransactionDetailsRequest detailsRequest){
        transactionInformationService.getTransactionDetails(detailsRequest);
    }
    @RequestMapping(value = "/savetabledata", method = RequestMethod.POST, consumes = "application/json")
    public void saveTableTransaction(TableDataRequest tableDataRequest){
        transactionInformationService.saveTableTransactionData(tableDataRequest);
    }

    @RequestMapping(value = "/gettabledetails/{tableID}/res/{resID}",method = RequestMethod.GET)
    public TableTransactionResponse getTableTransactionDetails(@PathVariable(value = "tableID")int id, @PathVariable(value = "resID")int resID){
        return transactionInformationService.getTableDetails(id,resID);
    }
}
