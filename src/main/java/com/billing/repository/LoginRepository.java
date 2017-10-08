package com.billing.repository;

import com.billing.model.LoginCredentials;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<LoginCredentials,Integer> {

    LoginCredentials save(LoginCredentials credentials);

}
