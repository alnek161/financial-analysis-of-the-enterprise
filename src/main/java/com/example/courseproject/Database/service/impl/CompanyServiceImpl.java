package com.example.courseproject.Database.service.impl;

import com.example.courseproject.Database.DAO.CompanyDao;
import com.example.courseproject.Database.DAO.impl.CompanyDaoImpl;
import com.example.courseproject.Database.entity.Company;
import com.example.courseproject.Database.service.CompanyService;
import lombok.NoArgsConstructor;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
@NoArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    CompanyDao companyDao = new CompanyDaoImpl();


    @Override
    public boolean addCompany(Company company) {
        boolean isAdded = false;
        try {
            companyDao.addCompany(company);
            isAdded = true;
        }
        catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isAdded;
    }

    @Override
    public boolean updateCompany(Company company) {
        boolean isUpdated = false;
        try {
            if(companyDao.updateCompany(company)) {
                isUpdated = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCompany(int companyId) {
        boolean isDeleted = false;
        try {
            if(companyDao.deleteCompany(companyId)) {
                isDeleted = true;
            }
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return isDeleted;
    }

    @Override
    public Company getCompanyById(int companyId) {
        Company company = null;
        try {
            company = companyDao.getCompanyById(companyId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return company;
    }

    @Override
    public Company getCompanyByName(String name) {
        Company company = null;
        try {
            company = companyDao.getCompanyByName(name);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return company;
    }

    @Override
    public List<Company> getCompanyByIdUser(int userId) {
        List<Company> companies = null;
        try {
            companies = companyDao.getCompanyByIdUser(userId);
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return companies;
    }
    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = null;
        try {
            companies = companyDao.getAllCompanies();
        } catch (HibernateError e) {
            throw new RuntimeException(e);
        }
        return companies;
    }
}