package com.internet_pharmacy.configuration;


import com.internet_pharmacy.database.InterfaceDaoMedicine;
import com.internet_pharmacy.database.InterfaceDaoOrder;
import com.internet_pharmacy.database.InterfaceDaoUser;
import com.internet_pharmacy.database.hibernate.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.internet_pharmacy.controllers",
        "com.internet_pharmacy.service",
        "com.internet_pharmacy.session"
})

public class TestConfiguration {

    @Bean
    public InterfaceDaoOrder orderDao() {
        return new StubDaoOrder();
    }

    @Bean
    public InterfaceDaoMedicine medicineDao() {
        return new StubDaoMedicine();
    }

    @Bean
    public InterfaceDaoUser userDao() {
        return new StubDaoUser();
    }

}
