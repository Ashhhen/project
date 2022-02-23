package com.internet_pharmacy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.internet_pharmacy.database.InterfaceDaoMedicine;
import com.internet_pharmacy.database.InterfaceDaoOrder;
import com.internet_pharmacy.model.Medicine;
import com.internet_pharmacy.model.Order;
import com.internet_pharmacy.model.OrderPosition;
import com.internet_pharmacy.service.InterfaceServOrder;
import com.internet_pharmacy.session.SesObject;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;
import java.util.Optional;

public class ImplServOrderOld implements InterfaceServOrder {

    @Resource
    SesObject sessionObj;

    @Autowired
    InterfaceDaoOrder interDaoOrder;

    @Autowired
    InterfaceDaoMedicine interDaoMedicine;

    @Override
    public void confOrder() {
        Order order = new Order(this.sessionObj.getUser(), new HashSet<>(this.sessionObj.getBasket().getOrderPositions()));
        this.interDaoOrder.addOrder(order);
        for (OrderPosition orderPosition : order.getOrderPositions()) {
            Optional<Medicine> medicineBox = interDaoMedicine.getMedicineById(orderPosition.getMedicine().getId());
            if(medicineBox.isPresent()) {
                medicineBox.get().setQuantity(medicineBox.get().getQuantity() - orderPosition.getQuantity());
            }
        }
        this.sessionObj.getBasket().clearOrderPositions();
    }

    @Override
    public List<Order> getOrdersForCurrentUser() {
        return this.interDaoOrder.getOrdersByUserId(this.sessionObj.getUser().getId());
    }
}
