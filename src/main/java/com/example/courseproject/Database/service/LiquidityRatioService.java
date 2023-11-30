package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.LiquidityRatio;

import java.util.List;

public interface LiquidityRatioService {
    boolean addLiquidityRatio(LiquidityRatio liquidityRatio);
    boolean updateLiquidityRatio(LiquidityRatio liquidityRatio);
    boolean deleteLiquidityRatio(int liquidityRatioId);
    LiquidityRatio getLiquidityRatioById(int liquidityRatioId);
    List<LiquidityRatio> getLiquidityRatiosByAnnualDataId(int annualDataId);
}
