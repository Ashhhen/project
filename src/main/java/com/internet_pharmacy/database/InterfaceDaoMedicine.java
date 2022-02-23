package com.internet_pharmacy.database;

import com.internet_pharmacy.model.Medicine;

import java.util.List;
import java.util.Optional;

public interface InterfaceDaoMedicine {
    List<Medicine> getMedicines();
    Optional<Medicine> getMedicineById(int medicineId);
    void updateMedicine(Medicine medicine);
}
