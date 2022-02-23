package com.internet_pharmacy.service;

import com.internet_pharmacy.model.Order;

import java.util.List;

public interface InterfaceServOrder {
    void confOrder();
    List<Order> getOrdersForCurrentUser();
}
