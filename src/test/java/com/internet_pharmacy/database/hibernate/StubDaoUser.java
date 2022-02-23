package com.internet_pharmacy.database.hibernate;

import com.internet_pharmacy.database.InterfaceDaoUser;
import com.internet_pharmacy.model.User;

import java.util.Optional;

public class StubDaoUser implements InterfaceDaoUser {
    @Override
    public void addUser(User user) {

    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        User user = new User();
        user.setId(1);
        user.setLogin("admin");
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
        user.setName("Oleksandr");
        user.setSurname("Liubich");

        return Optional.of(user);
    }
}
