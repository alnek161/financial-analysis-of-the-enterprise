package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.AnnualData;

import java.util.List;

public interface AnnualDataService {
    boolean addAnnualData(AnnualData annualData);
    boolean updateAnnualData(AnnualData annualData);
    boolean deleteAnnualData(int annualDataId);
    AnnualData getAnnualDataByYear(int year);

    AnnualData getAnnualDataById(int annualDataId);
    List<AnnualData> getAnnualDataByCompanyId(int companyId);
}
