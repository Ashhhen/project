package com.internet_pharmacy.service;

import com.internet_pharmacy.configuration.TestConfiguration;
import com.internet_pharmacy.service.impl.ImplServAuthenticate;
import com.internet_pharmacy.session.SesObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class TestServAuthenticate {

    @Autowired
    ImplServAuthenticate authenticationService;

    @Autowired
    SesObject sessionObject;

    @Test
    public void AuthenticationTest() {
        String login = "admin";
        String password = "admin";

        this.authenticationService.authenticate(login, password);

        Assert.assertTrue(this.sessionObject.isLog());
    }
}
