package com.internet_pharmacy.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internet_pharmacy.database.InterfaceDaoUser;
import com.internet_pharmacy.exceptions.ExceptLoginAlreadyUse;
import com.internet_pharmacy.model.User;
import com.internet_pharmacy.model.view.URegister;
import com.internet_pharmacy.service.InterfaceServAuthenticate;
import com.internet_pharmacy.session.SesObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ImplServAuthenticate implements InterfaceServAuthenticate {

    @Autowired
    InterfaceDaoUser interDaoUser;

    @Resource
    SesObject sessionObj;

    @Override
    public void authenticate(String login, String password) {
        Optional<User> user = this.interDaoUser.getUserByLogin(login);

        if(user.isEmpty() ||
                !user.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            return;
        }
        this.sessionObj.setUser(user.get());
    }

    @Override
    public void register(URegister userRegister) {
        Optional<User> userBox = this.interDaoUser.getUserByLogin(userRegister.getLogin());

        if(userBox.isPresent()) {
            throw new ExceptLoginAlreadyUse();
        }

        userRegister.setPassword(DigestUtils.md5Hex(userRegister.getPassword()));

        User user = new User();
        user.setLogin(userRegister.getLogin());
        user.setPassword(userRegister.getPassword());
        user.setSurname(userRegister.getSurname());
        user.setName(userRegister.getName());

        this.interDaoUser.addUser(user);
    }
}
