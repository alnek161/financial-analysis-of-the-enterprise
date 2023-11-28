package com.example.courseproject.Database.DAO.impl;

import com.example.courseproject.Database.DAO.CompanyDao;
import com.example.courseproject.Database.entity.Company;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyDaoImpl implements CompanyDao {

    private SessionFactory sessionFactory;

    public CompanyDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addCompany(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(company);
        transaction.commit();
        session.close();
    }

    @Override
    public void updateCompany(Company company) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(company);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteCompany(int companyId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Company company = session.get(Company.class, companyId);
        if (company != null) {
            session.delete(company);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public Company getCompanyById(int companyId) {
        Session session = sessionFactory.openSession();
        Company company = session.get(Company.class, companyId);
        session.close();
        return company;
    }
    @Override
    public List<Company> getCompanyByIdUser(int userId) {
        Session session = sessionFactory.openSession();
        Query<Company> query = session.createQuery("FROM Company WHERE idUser = :userId", Company.class);
        query.setParameter("userId", userId);
        List<Company> companyList = query.list();
        session.close();
        return companyList;
    }
    @Override
    public List<Company> getAllCompanies() {
        Session session = sessionFactory.openSession();
        Query<Company> query = session.createQuery("FROM Company", Company.class);
        List<Company> companyList = query.list();
        session.close();
        return companyList;
    }
}