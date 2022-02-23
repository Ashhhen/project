package com.internet_pharmacy.database;

import com.internet_pharmacy.model.Order;

import java.util.List;

public interface InterfaceDaoOrder {
    void addOrder(Order order);
    List<Order> getOrdersByUserId(int userId);
}
