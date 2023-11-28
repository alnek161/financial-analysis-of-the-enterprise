package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.OperationalAnalysisDao;
import com.example.courseproject.Database.entity.OperationalAnalysis;
import com.example.courseproject.Database.entity.Profitability;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OperationalAnalysisDaoImpl implements OperationalAnalysisDao {

    private SessionFactory sessionFactory;

    public OperationalAnalysisDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOperationalAnalysis(OperationalAnalysis operationalAnalysis) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(operationalAnalysis);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateOperationalAnalysis(OperationalAnalysis operationalAnalysis) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(operationalAnalysis);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteOperationalAnalysis(int operationalAnalysisId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OperationalAnalysis operationalAnalysis = session.get(OperationalAnalysis.class, operationalAnalysisId);
        if (operationalAnalysis != null) {
            session.delete(operationalAnalysis);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public OperationalAnalysis getOperationalAnalysisById(int operationalAnalysisId) {
        Session session = sessionFactory.openSession();
        OperationalAnalysis operationalAnalysis = session.get(OperationalAnalysis.class, operationalAnalysisId);
        session.close();
        return operationalAnalysis;
    }

    public List<OperationalAnalysis> getOperationalAnalysisByAnnualDataId(int annualDataId) {
        Session session = sessionFactory.openSession();
        Query<OperationalAnalysis> query = session.createQuery("SELECT lr FROM OperationalAnalysis lr WHERE lr.annualData.idAnnualData = :annualDataId", OperationalAnalysis.class);
        query.setParameter("annualDataId", annualDataId);
        List<OperationalAnalysis> operationalAnalysis = query.list();
        session.close();
        return operationalAnalysis;
    }
}
