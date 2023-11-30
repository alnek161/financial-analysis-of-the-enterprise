package com.example.courseproject.Database.DAO.impl;
import com.example.courseproject.Database.DAO.ProfitabilityDao;
import com.example.courseproject.Database.entity.LiquidityRatio;
import com.example.courseproject.Database.entity.MarketIndicators;
import com.example.courseproject.Database.entity.Profitability;
import com.example.courseproject.Database.entity.User;
import com.example.courseproject.Database.sessionFacctory.SessionFactoryImpl;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
@NoArgsConstructor
public class ProfitabilityDaoImpl implements ProfitabilityDao {


    @Override
    public boolean addProfitability(Profitability profitability) {
        return SessionUtils.saveEntity(profitability);
    }

    @Override
    public boolean updateProfitability(Profitability profitability) {
        return SessionUtils.updateEntity(profitability);
    }

    @Override
    public boolean deleteProfitability(int profitabilityId) {
        return SessionUtils.deleteEntity(profitabilityId, Profitability.class);
    }

    @Override
    public Profitability getProfitabilityById(int profitabilityId) {
        return SessionUtils.find(Profitability.class, profitabilityId, "idProfitability");
    }
    @Override
    public List<Profitability> getProfitabilityByAnnualDataId(int annualDataId) {
        return SessionUtils.findList(Profitability.class, annualDataId, "AnnualData_idAnnualData");
    }



    @Override
    public Profitability getProfitabilityByYear(int year) {
        try (Session session = SessionFactoryImpl.getSessionFactory().openSession()) {
            String hql = "SELECT pr FROM Profitability pr " +
                    "JOIN pr.annualData ad " +
                    "WHERE ad.year = :year";
            Query<Profitability> query = session.createQuery(hql, Profitability.class);
            query.setParameter("year", year);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
