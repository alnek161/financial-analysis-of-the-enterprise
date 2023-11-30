package com.example.courseproject.Database.DAO;

import com.example.courseproject.Database.entity.Company;

import java.util.List;

public interface CompanyDao {
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean deleteCompany(int companyId);
    Company getCompanyById(int companyId);

    Company getCompanyByName(String companyName);
    List<Company> getCompanyByIdUser(int userId);
    List<Company> getAllCompanies();
}
