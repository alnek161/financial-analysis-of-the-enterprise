package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.entity.OperationalAnalysis;

import java.util.List;

public interface OperationalAnalysisDao {
    boolean addOperationalAnalysis(OperationalAnalysis operationalAnalysis);
    boolean updateOperationalAnalysis(OperationalAnalysis operationalAnalysis);
    boolean deleteOperationalAnalysis(int operationalAnalysisId);
    OperationalAnalysis getOperationalAnalysisById(int operationalAnalysisId);
    List<OperationalAnalysis> getOperationalAnalysisByAnnualDataId(int annualDataId);
    OperationalAnalysis getOperationalAnalysisByYear(int year);

}
