package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.OperationalAnalysis;

import java.util.List;

public interface OperationalAnalysisService {
    boolean addOperationalAnalysis(OperationalAnalysis operationalAnalysis);
    boolean updateOperationalAnalysis(OperationalAnalysis operationalAnalysis);
    boolean deleteOperationalAnalysis(int operationalAnalysisId);
    OperationalAnalysis getOperationalAnalysisById(int operationalAnalysisId);
    List<OperationalAnalysis> getOperationalAnalysisByAnnualDataId(int annualDataId);
}
