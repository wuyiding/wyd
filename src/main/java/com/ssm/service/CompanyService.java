package com.ssm.service;
import com.ssm.mapper.CompanyMapper;
import com.ssm.model.Company;
import com.ssm.model.ResponseData;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;

/**
 * Created by wuyd on 2017/4/6.
 */
@Controller
@RequestMapping("/company")
public class CompanyService {

    private static SqlSessionFactory sessionFactory;
    private static SqlSession session;
    private static ApplicationContext ctx;
    private static CompanyMapper companyMapper;
    static {
        String mybatisResource = "mybatis.xml";

        /* 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件） */
        try{
            InputStream ins = Resources.getResourceAsStream(mybatisResource);
            //构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(ins);
            //创建能执行映射文件中sql的sqlSession
            session = sessionFactory.openSession();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public @ResponseBody Company getCompany(@PathVariable String username) {


        /**
         * 映射sql的标识字符串
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
//        String statement = "com.vstudio.mapping.Teacher.selectTeacherByID";//映射sql的标识字符串
//        Teacher teacher = session.selectOne(statement, 8000);

        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
        Company company = companyMapper.selectCompanyByUsername(username);

        return company;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Company> getAllCompany() {

//        try {
//            ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//            teacherMapper = (TeacherMapper) ctx.getBean("teacherMapper");
//        }catch(Exception e){
//            e.printStackTrace();
//        }
        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);

        List<Company> companies = companyMapper.selectCompanies();

        return companies;
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody ResponseData addTeacher(@RequestBody Company company) {
        ResponseData responseData = new ResponseData();

        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
        companyMapper.addCompany(company);
        session.commit();
        responseData.setSuccess(true);
        return responseData;
    }
    @RequestMapping(value = "{username}", method = RequestMethod.PUT)
    public @ResponseBody ResponseData updateCompany(@RequestBody Company company, @PathVariable String username) {
        ResponseData responseData = new ResponseData();

        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
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
        session.commit();

        responseData.setSuccess(true);
        return responseData;
    }
    @RequestMapping(value = "{username}", method = RequestMethod.DELETE)
     public @ResponseBody ResponseData deleteCompany(@PathVariable String username) {
                ResponseData responseData = new ResponseData();

                        CompanyMapper companyMapper = session.getMapper(CompanyMapper.class);
                companyMapper.deleteCompany(username);
                session.commit();

                        responseData.setSuccess(true);
               return responseData;
    }


}
