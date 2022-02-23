package com.internet_pharmacy.database.impl.hibernate;

import com.internet_pharmacy.database.InterfaceDaoUser;
import com.internet_pharmacy.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class ImplDaoUser implements InterfaceDaoUser {

    @Autowired
    SessionFactory sesFactory;

    @Override
    public Optional<User> getUserByLogin(String login) {
        Session ses = this.sesFactory.openSession();
        Query<User> query = ses.createQuery("FROM com.internet_pharmacy.model.User WHERE login = :login");
        query.setParameter("login", login);
        try {
            User user = query.getSingleResult();
            ses.close();
            return Optional.of(user);
        } catch (NoResultException except) {
            ses.close();
            return Optional.empty();
        }
    }

    @Override
    public void addUser(User user) {
        Session ses = this.sesFactory.openSession();
        Transaction trans = null;
        try {
            trans = ses.beginTransaction();
            ses.save(user);
            trans.commit();
        } catch (Exception except) {
            if(trans != null) {
                trans.rollback();
            }
        } finally {
            ses.close();
        }
    }

    @Override
    public Optional<User> getUserById(int id) {
        Session ses = this.sesFactory.openSession();
        Query<User> query = ses.createQuery("FROM com.internet_pharmacy.model.User WHERE id = :id");
        query.setParameter("id", id);
        try {
            User user = query.getSingleResult();
            ses.close();
            return Optional.of(user);
        } catch (NoResultException except) {
            ses.close();
            return Optional.empty();
        }
    }
}
