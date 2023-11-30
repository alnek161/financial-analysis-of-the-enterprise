package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.Profitability;

import java.util.List;

public interface ProfitabilityService {
    boolean addProfitability(Profitability profitability);
    boolean updateProfitability(Profitability profitability);
    boolean deleteProfitability(int profitabilityId);
    Profitability getProfitabilityById(int profitabilityId);
    List<Profitability> getProfitabilityByAnnualDataId(int annualDataId);
//    List<Profitability> getProfitabilityByAnnualDataIdAndYear(int annualDataId, int year);
}
