package com.example.courseproject.Database.service.impl;
import com.example.courseproject.Database.DAO.OperationalAnalysisDao;
import com.example.courseproject.Database.DAO.impl.OperationalAnalysisDaoImpl;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.entity.OperationalAnalysis;
import com.example.courseproject.Database.service.OperationalAnalysisService;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OperationalAnalysisServiceImpl implements OperationalAnalysisService {

    OperationalAnalysisDao operationalAnalysisDao = new OperationalAnalysisDaoImpl();

    @Override
    public boolean addOperationalAnalysis(OperationalAnalysis operationalAnalysis) {
        boolean isAdded = false;
        try {
            operationalAnalysisDao.addOperationalAnalysis(operationalAnalysis);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateOperationalAnalysis(OperationalAnalysis operationalAnalysis) {
        boolean isUpdated = false;
        try {
            if(operationalAnalysisDao.updateOperationalAnalysis(operationalAnalysis)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteOperationalAnalysis(int operationalAnalysisId) {
        boolean isDeleted = false;
        try {
            if(operationalAnalysisDao.deleteOperationalAnalysis(operationalAnalysisId)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public OperationalAnalysis getOperationalAnalysisById(int operationalAnalysisId) {
        OperationalAnalysis operationalAnalysis = null;
        try {
            operationalAnalysis = operationalAnalysisDao.getOperationalAnalysisById(operationalAnalysisId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return operationalAnalysis;
    }

    public List<OperationalAnalysis> getOperationalAnalysisByAnnualDataId(int annualDataId) {
        List<OperationalAnalysis> operationalAnalysis = null;
        try {
            operationalAnalysis = operationalAnalysisDao.getOperationalAnalysisByAnnualDataId(annualDataId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return operationalAnalysis;
    }
}
