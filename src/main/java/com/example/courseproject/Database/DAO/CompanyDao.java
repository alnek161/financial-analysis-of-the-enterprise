package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.Company;

import java.util.List;

public interface CompanyDao {
    void addCompany(Company company);
    void updateCompany(Company company);
    void deleteCompany(int companyId);
    Company getCompanyById(int companyId);

    List<Company> getCompanyByIdUser(int userId);
    List<Company> getAllCompanies();
}
