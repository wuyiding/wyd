package com.ssm.mapper;

import com.ssm.model.Company;

import java.util.List;

/**
 * Created by wuyd on 2017/4/6.
 */
public interface CompanyMapper {
    public Company selectCompanyByUsername(String username);
    public List<Company> selectCompanies();
    public void addCompany(Company company);
    public void updateCompany(Company company);
    public void deleteCompany(String username);

}
