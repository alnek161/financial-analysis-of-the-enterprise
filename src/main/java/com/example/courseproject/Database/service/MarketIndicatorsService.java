package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.MarketIndicators;

import java.util.List;

public interface MarketIndicatorsDao {
    void addMarketIndicators(MarketIndicators marketIndicators);
    void updateMarketIndicators(MarketIndicators marketIndicators);
    void deleteMarketIndicators(int marketIndicatorsId);
    MarketIndicators getMarketIndicatorsById(int marketIndicatorsId);
    List<MarketIndicators> getMarketIndicatorsByAnnualDataId(int annualDataId);
}
