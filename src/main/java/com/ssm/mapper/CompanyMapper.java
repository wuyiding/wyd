package com.ssm.mapper;

import com.ssm.model.Company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wuyd on 2017/4/6.
 */
public interface CompanyMapper {
    @Autowired
    public Company selectCompanyByUsername(String username);
    @Autowired
    public List<Company> selectCompanies();
    @Autowired
    public void addCompany(Company company);
    @Autowired
    public void updateCompany(Company company);
    @Autowired
    public void deleteCompany(String username);

}
