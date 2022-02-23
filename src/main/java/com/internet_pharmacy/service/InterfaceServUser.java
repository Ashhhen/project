package com.internet_pharmacy.service;


import com.internet_pharmacy.model.User;

public interface InterfaceServUser {
    User getUserById(int userId);
    void addUser(User user);
}