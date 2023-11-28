package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.LiquidityRatio;

import java.util.List;

public interface LiquidityRatioDao {
    void addLiquidityRatio(LiquidityRatio liquidityRatio);
    void updateLiquidityRatio(LiquidityRatio liquidityRatio);
    void deleteLiquidityRatio(int liquidityRatioId);
    LiquidityRatio getLiquidityRatioById(int liquidityRatioId);
    List<LiquidityRatio> getLiquidityRatiosByAnnualDataId(int annualDataId);
}
