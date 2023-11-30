package com.example.courseproject.Database.service.impl;
import com.example.courseproject.Database.DAO.AnnualDataDao;
import com.example.courseproject.Database.DAO.LiquidityRatioDao;
import com.example.courseproject.Database.DAO.impl.AnnualDataDaoImpl;
import com.example.courseproject.Database.DAO.impl.LiquidityRatioDaoImpl;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.service.LiquidityRatioService;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LiquidityRatioServiceImpl implements LiquidityRatioService {

    LiquidityRatioDao liquidityRatioDao = new LiquidityRatioDaoImpl();


    @Override
    public boolean addLiquidityRatio(LiquidityRatio liquidityRatio) {
        boolean isAdded = false;
        try {
            liquidityRatioDao.addLiquidityRatio(liquidityRatio);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateLiquidityRatio(LiquidityRatio liquidityRatio) {
        boolean isUpdated = false;
        try {
            if(liquidityRatioDao.updateLiquidityRatio(liquidityRatio)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteLiquidityRatio(int liquidityRatioId) {
        boolean isDeleted = false;
        try {
            if(liquidityRatioDao.deleteLiquidityRatio(liquidityRatioId)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public LiquidityRatio getLiquidityRatioById(int liquidityRatioId) {
        LiquidityRatio liquidityRatio = null;
        try {
            liquidityRatio = liquidityRatioDao.getLiquidityRatioById(liquidityRatioId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return liquidityRatio;
    }

    @Override
    public List<LiquidityRatio> getLiquidityRatiosByAnnualDataId(int annualDataId) {
        List<LiquidityRatio> liquidityRatio = null;
        try {
            liquidityRatio = liquidityRatioDao.getLiquidityRatiosByAnnualDataId(annualDataId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return liquidityRatio;
    }
}
