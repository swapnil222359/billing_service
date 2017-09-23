package org.billingservice.BillingServices;

import org.billingservice.Model.LoginCredentials;
import org.billingservice.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sony on 23-09-2017.
 */
@Service
public class LoginCredentialsService {

    @Autowired
    private LoginRepository loginRepository;
    public void saveLoginDetails(LoginCredentials credentials){
        loginRepository.save(credentials);
    }
}
