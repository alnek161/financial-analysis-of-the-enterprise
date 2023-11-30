package com.example.courseproject.Database.service;

import com.example.courseproject.Database.entity.Company;

import java.util.List;

public interface CompanyService {
    boolean addCompany(Company company);
    boolean updateCompany(Company company);
    boolean deleteCompany(int companyId);
    Company getCompanyById(int companyId);
    Company getCompanyByName(String name);
    List<Company> getCompanyByIdUser(int userId);
    List<Company> getAllCompanies();
}
