package com.internet_pharmacy.service;

import com.internet_pharmacy.model.view.URegister;

public interface InterfaceServAuthenticate {
    void authenticate(String login, String password);
    void register(URegister userRegister);
}
