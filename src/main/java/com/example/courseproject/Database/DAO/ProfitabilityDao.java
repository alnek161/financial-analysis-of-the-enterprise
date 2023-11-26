package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.Profitability;

import java.util.List;

public interface ProfitabilityDao {
    void addProfitability(Profitability profitability);
    void updateProfitability(Profitability profitability);
    void deleteProfitability(int profitabilityId);
    Profitability getProfitabilityById(int profitabilityId);
    List<Profitability> getProfitabilityByAnnualDataId(int annualDataId);
//    List<Profitability> getProfitabilityByAnnualDataIdAndYear(int annualDataId, int year);
}
