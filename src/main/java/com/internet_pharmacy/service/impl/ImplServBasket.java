package com.internet_pharmacy.service.impl;

import com.internet_pharmacy.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internet_pharmacy.database.InterfaceDaoMedicine;
import com.internet_pharmacy.model.OrderPosition;
import com.internet_pharmacy.service.InterfaceServBasket;
import com.internet_pharmacy.session.SesObject;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ImplServBasket implements InterfaceServBasket {

    @Autowired
    InterfaceDaoMedicine interDaoMedicine;

    @Resource
    SesObject sessionObj;

    public void addMedicineToBasket(int medicineId) {
        Optional<Medicine> medicineBox = this.interDaoMedicine.getMedicineById(medicineId);

        if(medicineBox.isEmpty()) {
            return;
        }

        Medicine medicine = medicineBox.get();
        if(medicine.getQuantity() <= 0) {
            return;
        }

        for(OrderPosition orderPosition : this.sessionObj
                .getBasket().getOrderPositions()) {
            if(orderPosition.getMedicine().getId() == medicineId) {
                orderPosition.incrementQuantity();
                return;
            }
        }

        OrderPosition orderPosition = new OrderPosition(0, medicine, 1);
        this.sessionObj.getBasket().getOrderPositions().add(orderPosition);
    }
}
