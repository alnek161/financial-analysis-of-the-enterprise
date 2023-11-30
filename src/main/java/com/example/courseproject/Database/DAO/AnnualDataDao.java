package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.AnnualData;

import java.util.List;

public interface AnnualDataDao {
    boolean addAnnualData(AnnualData annualData);
    boolean updateAnnualData(AnnualData annualData);
    boolean deleteAnnualData(int annualDataId);
    AnnualData getAnnualDataById(int annualDataId);
    AnnualData getAnnualDataByYear(int year);
    List<AnnualData> getAnnualDataByCompanyId(int companyId);
}
