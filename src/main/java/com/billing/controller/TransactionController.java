package com.billing.controller;

import com.billing.service.TransactionInformationService;
import com.billing.model.TransactionDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

}
