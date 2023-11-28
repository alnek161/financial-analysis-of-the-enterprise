package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.LiquidityRatioDao;
import com.example.courseproject.Database.entity.LiquidityRatio;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LiquidityRatioDaoImpl implements LiquidityRatioDao {

    private SessionFactory sessionFactory;

    public LiquidityRatioDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addLiquidityRatio(LiquidityRatio liquidityRatio) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(liquidityRatio);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateLiquidityRatio(LiquidityRatio liquidityRatio) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(liquidityRatio);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteLiquidityRatio(int liquidityRatioId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        LiquidityRatio liquidityData = session.get(LiquidityRatio.class, liquidityRatioId);
        if (liquidityData != null) {
            session.delete(liquidityData);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public LiquidityRatio getLiquidityRatioById(int liquidityRatioId) {
        Session session = sessionFactory.openSession();
        LiquidityRatio liquidityRatio = session.get(LiquidityRatio.class, liquidityRatioId);
        session.close();
        return liquidityRatio;
    }

    @Override
    public List<LiquidityRatio> getLiquidityRatiosByAnnualDataId(int annualDataId) {
        Session session = sessionFactory.openSession();
        Query<LiquidityRatio> query = session.createQuery("SELECT lr FROM LiquidityRatio lr WHERE lr.annualData.idAnnualData = :annualDataId", LiquidityRatio.class);
        query.setParameter("annualDataId", annualDataId);
        List<LiquidityRatio> liquidityRatios = query.list();
        session.close();
        return liquidityRatios;
    }
}
