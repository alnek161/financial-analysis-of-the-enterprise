package com.example.courseproject.Database.service.impl;
import com.example.courseproject.Database.DAO.ProfitabilityDao;
import com.example.courseproject.Database.DAO.impl.ProfitabilityDaoImpl;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.entity.Profitability;
import com.example.courseproject.Database.service.ProfitabilityService;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProfitabilityServiceImpl implements ProfitabilityService {

    ProfitabilityDao profitabilityDao = new ProfitabilityDaoImpl();


    @Override
    public boolean addProfitability(Profitability profitability) {
        boolean isAdded = false;
        try {
            profitabilityDao.addProfitability(profitability);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateProfitability(Profitability profitability) {
        boolean isUpdated = false;
        try {
            if(profitabilityDao.updateProfitability(profitability)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteProfitability(int profitabilityId) {
        boolean isDeleted = false;
        try {
            if(profitabilityDao.deleteProfitability(profitabilityId)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public Profitability getProfitabilityById(int profitabilityId) {
        Profitability profitability = null;
        try {
            profitability = profitabilityDao.getProfitabilityById(profitabilityId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return profitability;
    }

    public List<Profitability> getProfitabilityByAnnualDataId(int annualDataId) {
        List<Profitability> profitabilitys = null;
        try {
            profitabilitys = profitabilityDao.getProfitabilityByAnnualDataId(annualDataId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return profitabilitys;
    }
}
