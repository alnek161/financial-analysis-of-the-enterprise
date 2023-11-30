package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.OperationalAnalysisDao;
import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.entity.OperationalAnalysis;
import com.example.courseproject.Database.entity.Profitability;
import com.example.courseproject.Database.sessionFacctory.SessionFactoryImpl;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
@NoArgsConstructor
public class OperationalAnalysisDaoImpl implements OperationalAnalysisDao {


    @Override
    public boolean addOperationalAnalysis(OperationalAnalysis operationalAnalysis) {
        return SessionUtils.saveEntity(operationalAnalysis);
    }

    @Override
    public boolean updateOperationalAnalysis(OperationalAnalysis operationalAnalysis) {
        return SessionUtils.updateEntity(operationalAnalysis);
    }

    @Override
    public boolean deleteOperationalAnalysis(int operationalAnalysisId) {
        return SessionUtils.deleteEntity(operationalAnalysisId, OperationalAnalysis.class);
    }

    @Override
    public OperationalAnalysis getOperationalAnalysisById(int operationalAnalysisId) {
        return SessionUtils.find(OperationalAnalysis.class, operationalAnalysisId, "idOperationalAnalysis");
    }

    public List<OperationalAnalysis> getOperationalAnalysisByAnnualDataId(int annualDataId) {
        return SessionUtils.findList(OperationalAnalysis.class, annualDataId, "AnnualData_idAnnualData");
    }
    @Override
    public OperationalAnalysis getOperationalAnalysisByYear(int year) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            String hql = "SELECT oa FROM OperationalAnalysis oa " +
                    "JOIN oa.annualData ad " +
                    "WHERE ad.year = :year";
            Query<OperationalAnalysis> query = session.createQuery(hql, OperationalAnalysis.class);
            query.setParameter("year", year);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
