package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.ProfitabilityDao;
import com.example.courseproject.Database.entity.MarketIndicators;
import com.example.courseproject.Database.entity.Profitability;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProfitabilityDaoImpl implements ProfitabilityDao {

    private SessionFactory sessionFactory;

    public ProfitabilityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProfitability(Profitability profitability) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(profitability);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateProfitability(Profitability profitability) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(profitability);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteProfitability(int profitabilityId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Profitability profitability = session.get(Profitability.class, profitabilityId);
        if (profitability != null) {
            session.delete(profitability);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Profitability getProfitabilityById(int profitabilityId) {
        Session session = sessionFactory.openSession();
        Profitability profitability = session.get(Profitability.class, profitabilityId);
        session.close();
        return profitability;
    }

    public List<Profitability> getProfitabilityByAnnualDataId(int annualDataId) {
        Session session = sessionFactory.openSession();
        Query<Profitability> query = session.createQuery("SELECT lr FROM Profitability lr WHERE lr.annualData.idAnnualData = :annualDataId", Profitability.class);
        query.setParameter("annualDataId", annualDataId);
        List<Profitability> profitability = query.list();
        session.close();
        return profitability;
    }
}
