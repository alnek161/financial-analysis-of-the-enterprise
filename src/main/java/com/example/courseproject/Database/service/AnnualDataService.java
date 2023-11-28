package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.AnnualData;

import java.util.List;

public interface AnnualDataDao {
    void addAnnualData(AnnualData annualData);
    void updateAnnualData(AnnualData annualData);
    void deleteAnnualData(int annualDataId);
    AnnualData getAnnualDataById(int annualDataId);
    List<AnnualData> getAnnualDataByCompanyId(int companyId);
}
