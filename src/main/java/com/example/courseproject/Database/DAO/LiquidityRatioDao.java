package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.LiquidityRatio;

import java.util.List;

public interface LiquidityRatioDao {
    boolean addLiquidityRatio(LiquidityRatio liquidityRatio);
    boolean updateLiquidityRatio(LiquidityRatio liquidityRatio);
    boolean deleteLiquidityRatio(int liquidityRatioId);
    LiquidityRatio getLiquidityRatioById(int liquidityRatioId);
    List<LiquidityRatio> getLiquidityRatiosByAnnualDataId(int annualDataId);
    LiquidityRatio getLiquidityRatioByYear(int year);
}
