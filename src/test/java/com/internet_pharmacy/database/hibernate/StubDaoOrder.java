package com.internet_pharmacy.database.hibernate;

import com.internet_pharmacy.database.InterfaceDaoOrder;
import com.internet_pharmacy.model.Order;

import java.util.List;

public class StubDaoOrder implements InterfaceDaoOrder {

    @Override
    public void addOrder(Order order) {
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return null;
    }
}

