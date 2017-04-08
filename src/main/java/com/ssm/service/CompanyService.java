package com.ssm.service;
import com.ssm.mapper.CompanyMapper;
import com.ssm.model.Company;
import com.ssm.model.ResponseData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by wuyd on 2017/4/6.
 */
@Controller
@RequestMapping("/company")
public class CompanyService {

//    private static SqlSessionFactory sessionFactory;
//    private static SqlSession session;
    private static ApplicationContext ctx;
    private static CompanyMapper companyMapper;
    static {
        // spring-mybatis
        try {
            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
            companyMapper = (CompanyMapper) ctx.getBean("companyMapper");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public @ResponseBody Company getCompany(@PathVariable String username) {

//        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
        Company company = companyMapper.selectCompanyByUsername(username);
        return company;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Company> getAllCompanies() {

        List<Company> companies = companyMapper.selectCompanies();
        return companies;
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseData addCompany(@RequestBody Company company) {
        ResponseData responseData = new ResponseData();
        companyMapper.addCompany(company);
        responseData.setSuccess(true);
        return responseData;
    }
    @RequestMapping(value = "{username}", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateCompany(@RequestBody Company company, @PathVariable String username) {
        ResponseData responseData = new ResponseData();
        Company companyForUpdate = companyMapper.selectCompanyByUsername(username);
        companyForUpdate.setCompanyname(company.getCompanyname());
        companyForUpdate.setStarttime(company.getStarttime());
        companyForUpdate.setPayment(company.getPayment());
        companyForUpdate.setTelephone(company.getTelephone());
        companyForUpdate.setWorkernumber(company.getWorkernumber());
        companyForUpdate.setIncome(company.getIncome());
        companyForUpdate.setVip(company.getVip());
        companyForUpdate.setPassword(company.getPassword());
        companyForUpdate.setPrice(company.getPrice());

        // to finish all setter...
        companyMapper.updateCompany(companyForUpdate);


        responseData.setSuccess(true);
        return responseData;
    }
    @RequestMapping(value = "{username}", method = RequestMethod.DELETE)
     public @ResponseBody ResponseData deleteCompany(@PathVariable String username) {
        ResponseData responseData = new ResponseData();
        companyMapper.deleteCompany(username);

        responseData.setSuccess(true);
               return responseData;
    }


}
