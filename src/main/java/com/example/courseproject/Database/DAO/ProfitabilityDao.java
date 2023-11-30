package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.entity.Profitability;

import java.util.List;

public interface ProfitabilityDao {
    boolean addProfitability(Profitability profitability);
    boolean updateProfitability(Profitability profitability);
    boolean deleteProfitability(int profitabilityId);
    Profitability getProfitabilityById(int profitabilityId);
    List<Profitability> getProfitabilityByAnnualDataId(int annualDataId);
    Profitability getProfitabilityByYear(int year);

//    List<Profitability> getProfitabilityByAnnualDataIdAndYear(int annualDataId, int year);
}
