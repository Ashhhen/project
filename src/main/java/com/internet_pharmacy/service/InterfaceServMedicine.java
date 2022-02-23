package com.internet_pharmacy.service;

import com.internet_pharmacy.model.Medicine;

import java.util.List;

public interface InterfaceServMedicine {
    List<Medicine> getAllMedicines();
    Medicine getMedicineById(int medicineId);
    void updateMedicine(Medicine medicine);
}
