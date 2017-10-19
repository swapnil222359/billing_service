package com.billing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ServiceStarter {
    public static void main( String[] args )
    {
        SpringApplication.run(ServiceStarter.class,args);
    }
}
