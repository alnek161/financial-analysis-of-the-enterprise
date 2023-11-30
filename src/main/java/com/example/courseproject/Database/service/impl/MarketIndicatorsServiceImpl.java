package com.example.courseproject.Database.service.impl;
import com.example.courseproject.Database.DAO.MarketIndicatorsDao;
import com.example.courseproject.Database.DAO.impl.MarketIndicatorsDaoImpl;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.entity.MarketIndicators;
import com.example.courseproject.Database.service.MarketIndicatorsService;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MarketIndicatorsServiceImpl implements MarketIndicatorsService {

    MarketIndicatorsDao marketIndicatorsDao = new MarketIndicatorsDaoImpl();


    @Override
    public boolean addMarketIndicators(MarketIndicators marketIndicators) {
        boolean isAdded = false;
        try {
            marketIndicatorsDao.addMarketIndicators(marketIndicators);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateMarketIndicators(MarketIndicators marketIndicators) {
        boolean isUpdated = false;
        try {
            if(marketIndicatorsDao.updateMarketIndicators(marketIndicators)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteMarketIndicators(int marketIndicatorsId) {
        boolean isDeleted = false;
        try {
            if(marketIndicatorsDao.deleteMarketIndicators(marketIndicatorsId)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public MarketIndicators getMarketIndicatorsById(int marketIndicatorsId) {
        MarketIndicators marketIndicators = null;
        try {
            marketIndicators = marketIndicatorsDao.getMarketIndicatorsById(marketIndicatorsId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return marketIndicators;
    }

    @Override
    public List<MarketIndicators> getMarketIndicatorsByAnnualDataId(int annualDataId) {
        List<MarketIndicators> marketIndicators = null;
        try {
            marketIndicators = marketIndicatorsDao.getMarketIndicatorsByAnnualDataId(annualDataId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return marketIndicators;
    }
}
