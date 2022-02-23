package com.internet_pharmacy.service.impl;

import com.internet_pharmacy.database.InterfaceDaoMedicine;
import com.internet_pharmacy.model.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internet_pharmacy.service.InterfaceServMedicine;

import java.util.List;
import java.util.Optional;

@Service
public class ImplServMedicine implements InterfaceServMedicine {

    @Autowired
    InterfaceDaoMedicine interDaoMedicine;

    public List<Medicine> getAllMedicines() {
        return this.interDaoMedicine.getMedicines();
    }

    @Override
    public Medicine getMedicineById(int medicineId) {
        Optional<Medicine> medicineOptional = interDaoMedicine.getMedicineById(medicineId);

        if (medicineOptional.isEmpty()) {
            return null;
        }

        return medicineOptional.get();
    }

    public void updateMedicine(Medicine medicine) {
        this.interDaoMedicine.updateMedicine(medicine);

    }
}
