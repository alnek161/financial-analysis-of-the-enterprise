package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.MarketIndicatorsDao;
import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.entity.MarketIndicators;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MarketIndicatorsDaoImpl implements MarketIndicatorsDao {

    private SessionFactory sessionFactory;

    public MarketIndicatorsDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addMarketIndicators(MarketIndicators marketIndicators) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(marketIndicators);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateMarketIndicators(MarketIndicators marketIndicators) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(marketIndicators);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteMarketIndicators(int marketIndicatorsId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        MarketIndicators marketIndicators = session.get(MarketIndicators.class, marketIndicatorsId);
        if (marketIndicators != null) {
            session.delete(marketIndicators);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public MarketIndicators getMarketIndicatorsById(int marketIndicatorsId) {
        Session session = sessionFactory.openSession();
        MarketIndicators marketIndicators = session.get(MarketIndicators.class, marketIndicatorsId);
        session.close();
        return marketIndicators;
    }

    @Override
    public List<MarketIndicators> getMarketIndicatorsByAnnualDataId(int annualDataId) {
        Session session = sessionFactory.openSession();
        Query<MarketIndicators> query = session.createQuery("SELECT lr FROM MarketIndicators lr WHERE lr.annualData.idAnnualData = :annualDataId", MarketIndicators.class);
        query.setParameter("annualDataId", annualDataId);
        List<MarketIndicators> marketIndicators = query.list();
        session.close();
        return marketIndicators;
    }
}
