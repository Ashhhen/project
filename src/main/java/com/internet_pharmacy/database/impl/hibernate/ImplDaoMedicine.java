package com.internet_pharmacy.database.impl.hibernate;

import com.internet_pharmacy.database.InterfaceDaoMedicine;
import com.internet_pharmacy.model.Medicine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@Repository
public class ImplDaoMedicine implements InterfaceDaoMedicine {

    @Autowired
    SessionFactory sesFactory;

    @Override
    public List<Medicine> getMedicines() {
        Session ses = this.sesFactory.openSession();
        Query<Medicine> query = ses.createQuery("FROM com.internet_pharmacy.model.Medicine");
        List<Medicine> res = query.getResultList();
        ses.close();
        return res;
    }

    @Override
    public Optional<Medicine> getMedicineById(int medicineId) {
        Session ses = this.sesFactory.openSession();
        Query<Medicine> query = ses.createQuery("FROM com.internet_pharmacy.model.Medicine WHERE id = :id");
        query.setParameter("id", medicineId);
        try {
            Medicine medicine = query.getSingleResult();
            ses.close();
            return Optional.of(medicine);
        } catch (NoResultException except) {
            ses.close();
            return Optional.empty();
        }
    }

    @Override
    public void updateMedicine(Medicine medicine) {
        Session ses = this.sesFactory.openSession();
        Transaction trans = null;
        try {
            trans = ses.beginTransaction();
            ses.update(medicine);
            trans.commit();
        } catch (Exception except) {
            if(trans != null) {
                trans.rollback();
            }
        } finally {
            ses.close();
        }
    }
}
