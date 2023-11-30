package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.MarketIndicatorsDao;
import com.example.courseproject.Database.entity.MarketIndicators;
import com.example.courseproject.Database.sessionFacctory.SessionFactoryImpl;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
@NoArgsConstructor
public class MarketIndicatorsDaoImpl implements MarketIndicatorsDao {

    @Override
    public boolean addMarketIndicators(MarketIndicators marketIndicators) {
        return SessionUtils.saveEntity(marketIndicators);
    }

    @Override
    public boolean updateMarketIndicators(MarketIndicators marketIndicators) {
        return SessionUtils.updateEntity(marketIndicators);
    }

    @Override
    public boolean deleteMarketIndicators(int marketIndicatorsId) {
        return SessionUtils.deleteEntity(marketIndicatorsId, MarketIndicators.class);
    }

    @Override
    public MarketIndicators getMarketIndicatorsById(int marketIndicatorsId) {
        return SessionUtils.find(MarketIndicators.class, marketIndicatorsId, "idMarketIndicators");
    }

    @Override
    public List<MarketIndicators> getMarketIndicatorsByAnnualDataId(int annualDataId) {
        return SessionUtils.findList(MarketIndicators.class, annualDataId, "AnnualData_idAnnualData");
    }

    @Override
    public MarketIndicators getMarketIndicatorsByYear(int year) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            String hql = "SELECT mi FROM LiquidityRatio mi " +
                    "JOIN mi.annualData ad " +
                    "WHERE ad.year = :year";
            Query<MarketIndicators> query = session.createQuery(hql, MarketIndicators.class);
            query.setParameter("year", year);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
