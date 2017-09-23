package com.billing.repository;

import com.billing.model.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sony on 23-09-2017.
 */
public interface LoginRepository extends CrudRepository<LoginCredentials,Integer> {

    LoginCredentials save(LoginCredentials credentials);
}
