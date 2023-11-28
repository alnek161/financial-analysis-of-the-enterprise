package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.OperationalAnalysis;

import java.util.List;

public interface OperationalAnalysisDao {
    void addOperationalAnalysis(OperationalAnalysis operationalAnalysis);
    void updateOperationalAnalysis(OperationalAnalysis operationalAnalysis);
    void deleteOperationalAnalysis(int operationalAnalysisId);
    OperationalAnalysis getOperationalAnalysisById(int operationalAnalysisId);
    List<OperationalAnalysis> getOperationalAnalysisByAnnualDataId(int annualDataId);
}
