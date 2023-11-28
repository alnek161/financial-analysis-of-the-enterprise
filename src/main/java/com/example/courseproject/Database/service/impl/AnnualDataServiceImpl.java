package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.AnnualDataDao;
import com.example.courseproject.Database.entity.AnnualData;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AnnualDataDaoImpl implements AnnualDataDao {

    private SessionFactory sessionFactory;

    public AnnualDataDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addAnnualData(AnnualData annualData) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(annualData);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateAnnualData(AnnualData annualData) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(annualData);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteAnnualData(int annualDataId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        AnnualData annualData = session.get(AnnualData.class, annualDataId);
        if (annualData != null) {
            session.delete(annualData);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public AnnualData getAnnualDataById(int annualDataId) {
        Session session = sessionFactory.openSession();
        AnnualData annualData = session.get(AnnualData.class, annualDataId);
        session.close();
        return annualData;
    }

    @Override
    public List<AnnualData> getAnnualDataByCompanyId(int companyId) {
        Session session = sessionFactory.openSession();
        Query<AnnualData> query = session.createQuery("FROM AnnualData WHERE company.idCompany = :companyId", AnnualData.class);
        query.setParameter("companyId", companyId);
        List<AnnualData> annualDataList = query.list();
        session.close();
        return annualDataList;
    }
}

