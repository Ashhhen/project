package com.internet_pharmacy.database.impl.hibernate;

import com.internet_pharmacy.database.InterfaceDaoOrder;
import com.internet_pharmacy.model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImplDaoOrder implements InterfaceDaoOrder {

    @Autowired
    SessionFactory sesFactory;

    @Override
    public void addOrder(Order order) {
        Session ses = this.sesFactory.openSession();
        Transaction trans = null;
        try {
            trans = ses.beginTransaction();
            ses.save(order);
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
    public List<Order> getOrdersByUserId(int userId) {
        Session ses = this.sesFactory.openSession();
        Query<Order> query = ses.createQuery("FROM com.internet_pharmacy.model.Order WHERE user_id = :userId");
        query.setParameter("userId", userId);
        List<Order> res = query.getResultList();
        ses.close();
        return res;
    }
}
