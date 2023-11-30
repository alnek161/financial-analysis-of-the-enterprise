package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.AnnualDataDao;
import com.example.courseproject.Database.entity.AnnualData;
import com.example.courseproject.Database.entity.OperationalAnalysis;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class AnnualDataDaoImpl implements AnnualDataDao {


    @Override
    public boolean addAnnualData(AnnualData annualData) {
        return SessionUtils.saveEntity(annualData);
    }

    @Override
    public boolean updateAnnualData(AnnualData annualData) {
        return SessionUtils.updateEntity(annualData);
    }

    @Override
    public boolean deleteAnnualData(int annualDataId) {
        return SessionUtils.deleteEntity(annualDataId, AnnualData.class);
    }

    @Override
    public AnnualData getAnnualDataById(int annualDataId) {
        return SessionUtils.find(AnnualData.class, annualDataId, "idAnnualData");
    }

    @Override
    public AnnualData getAnnualDataByYear(int year) {
        return SessionUtils.find(AnnualData.class, year, "year");
    }

    @Override
    public List<AnnualData> getAnnualDataByCompanyId(int companyId) {
        return SessionUtils.findList(AnnualData.class, companyId, "idCompany");
    }
}

