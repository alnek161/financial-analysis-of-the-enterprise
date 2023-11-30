package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.MarketIndicators;

import java.util.List;

public interface MarketIndicatorsService {
    boolean addMarketIndicators(MarketIndicators marketIndicators);
    boolean updateMarketIndicators(MarketIndicators marketIndicators);
    boolean deleteMarketIndicators(int marketIndicatorsId);
    MarketIndicators getMarketIndicatorsById(int marketIndicatorsId);
    List<MarketIndicators> getMarketIndicatorsByAnnualDataId(int annualDataId);
}
