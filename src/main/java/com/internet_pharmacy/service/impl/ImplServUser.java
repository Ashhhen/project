package com.internet_pharmacy.service.impl;

import com.internet_pharmacy.database.InterfaceDaoUser;
import com.internet_pharmacy.model.User;
import com.internet_pharmacy.service.InterfaceServUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImplServUser implements InterfaceServUser {

    @Autowired
    InterfaceDaoUser interDaoUser;

    @Override
    public User getUserById(int userId) {
        Optional<User> userOpt = interDaoUser.getUserById(userId);

        if (userOpt.isEmpty()) {
            return null;
        }

        return userOpt.get();
    }

    @Override
    public void addUser(User user) {
        this.interDaoUser.addUser(user);

    }
}