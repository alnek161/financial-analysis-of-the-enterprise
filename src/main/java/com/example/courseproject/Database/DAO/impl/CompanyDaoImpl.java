package com.example.courseproject.Database.DAO.impl;

import com.example.courseproject.Database.DAO.CompanyDao;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.sessionFacctory.SessionFactoryImpl;
import com.example.courseproject.Database.utils.SessionUtils;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class CompanyDaoImpl implements CompanyDao {



    @Override
    public boolean addCompany(Company company) {
        return SessionUtils.saveEntity(company);
    }

    @Override
    public boolean updateCompany(Company company) {
        return SessionUtils.updateEntity(company);
    }

    @Override
    public boolean deleteCompany(int companyId) {
        return SessionUtils.deleteEntity(companyId, Company.class);
    }

    @Override
    public Company getCompanyById(int companyId) {
        return SessionUtils.find(Company.class, companyId, "idCompany");

    }

    @Override
    public Company getCompanyByName(String companyName) {
        return SessionUtils.find(Company.class, companyName, "name");
    }

    @Override
    public List<Company> getCompanyByIdUser(int userId) {
        return SessionUtils.findList(Company.class, userId, "idUser");
    }
    @Override
    public List<Company> getAllCompanies() {
        return (List<Company>) SessionFactoryImpl.getSessionFactory().openSession().createQuery("From company").list();
    }

}