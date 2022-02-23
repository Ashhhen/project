package com.internet_pharmacy.database.hibernate;

import com.internet_pharmacy.database.InterfaceDaoMedicine;
import com.internet_pharmacy.model.Medicine;

import java.util.List;
import java.util.Optional;

public class StubDaoMedicine implements InterfaceDaoMedicine {
    @Override
    public List<Medicine> getMedicines() {
        return null;
    }

    @Override
    public Optional<Medicine> getMedicineById(int medicineId) {
        return Optional.empty();
    }

    @Override
    public void updateMedicine(Medicine medicine) {
    }
}

