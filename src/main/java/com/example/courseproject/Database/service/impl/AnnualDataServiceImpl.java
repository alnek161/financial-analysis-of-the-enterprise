package com.example.courseproject.Database.service.impl;
import com.example.courseproject.Database.DAO.AnnualDataDao;
import com.example.courseproject.Database.DAO.CompanyDao;
import com.example.courseproject.Database.DAO.impl.AnnualDataDaoImpl;
import com.example.courseproject.Database.DAO.impl.CompanyDaoImpl;
import com.example.courseproject.Database.entity.AnnualData;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.service.AnnualDataService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AnnualDataServiceImpl implements AnnualDataService {

    AnnualDataDao annualDataDao = new AnnualDataDaoImpl();

    @Override
    public boolean addAnnualData(AnnualData annualData) {
        boolean isAdded = false;
        try {
            annualDataDao.addAnnualData(annualData);
            isAdded = true;
        }
        catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateAnnualData(AnnualData annualData) {
        boolean isUpdated = false;
        try {
            if(annualDataDao.updateAnnualData(annualData)) {
                isUpdated = true;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAnnualData(int annualDataId) {
        boolean isDeleted = false;
        try {
            if(annualDataDao.deleteAnnualData(annualDataId)) {
                isDeleted = true;
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public AnnualData getAnnualDataByYear(int year) {
        AnnualData annualData = null;
        try {
            annualData = annualDataDao.getAnnualDataByYear(year);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return annualData;
    }

    @Override
    public AnnualData getAnnualDataById(int annualDataId) {
        AnnualData annualData = null;
        try {
            annualData = annualDataDao.getAnnualDataById(annualDataId);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return annualData;
    }

    @Override
    public List<AnnualData> getAnnualDataByCompanyId(int companyId) {
        List<AnnualData> annualData = null;
        try {
            annualData = annualDataDao.getAnnualDataByCompanyId(companyId);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return annualData;
    }
}

