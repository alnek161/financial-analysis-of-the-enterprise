package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.entity.MarketIndicators;

import java.util.List;

public interface MarketIndicatorsDao {
    boolean addMarketIndicators(MarketIndicators marketIndicators);
    boolean updateMarketIndicators(MarketIndicators marketIndicators);
    boolean deleteMarketIndicators(int marketIndicatorsId);
    MarketIndicators getMarketIndicatorsById(int marketIndicatorsId);
    List<MarketIndicators> getMarketIndicatorsByAnnualDataId(int annualDataId);
    MarketIndicators getMarketIndicatorsByYear(int year);

}
