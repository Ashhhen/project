package com.internet_pharmacy.database;

import com.internet_pharmacy.model.User;

import java.util.Optional;

public interface InterfaceDaoUser {
    Optional<User> getUserByLogin(String login);
    void addUser(User user);
    Optional<User> getUserById(int id);
}
