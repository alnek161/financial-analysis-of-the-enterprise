package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.LiquidityRatioDao;
import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.sessionFacctory.SessionFactoryImpl;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
@NoArgsConstructor
public class LiquidityRatioDaoImpl implements LiquidityRatioDao {


    @Override
    public boolean addLiquidityRatio(LiquidityRatio liquidityRatio) {
        return SessionUtils.saveEntity(liquidityRatio);
    }

    @Override
    public boolean updateLiquidityRatio(LiquidityRatio liquidityRatio) {
        return SessionUtils.updateEntity(liquidityRatio);
    }

    @Override
    public boolean deleteLiquidityRatio(int liquidityRatioId) {
        return SessionUtils.deleteEntity(liquidityRatioId, LiquidityRatio.class);
    }

    @Override
    public LiquidityRatio getLiquidityRatioById(int liquidityRatioId) {
        return SessionUtils.find(LiquidityRatio.class, liquidityRatioId, "idLiquidityRatio");
    }

    @Override
    public List<LiquidityRatio> getLiquidityRatiosByAnnualDataId(int annualDataId) {
        return SessionUtils.findList(LiquidityRatio.class, annualDataId, "AnnualData_idAnnualData");

    }

    @Override
    public LiquidityRatio getLiquidityRatioByYear(int year) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            String hql = "SELECT lr FROM LiquidityRatio lr " +
                    "JOIN lr.annualData ad " +
                    "WHERE ad.year = :year";
            Query<LiquidityRatio> query = session.createQuery(hql, LiquidityRatio.class);
            query.setParameter("year", year);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
