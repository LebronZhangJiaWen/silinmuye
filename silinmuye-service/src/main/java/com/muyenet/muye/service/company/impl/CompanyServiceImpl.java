package com.muyenet.muye.service.company.impl;

import com.muyenet.muye.dao.company.CompanyDao;
import com.muyenet.muye.model.company.Company;
import com.muyenet.muye.service.company.CompanyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("companyService")
public class CompanyServiceImpl
        implements CompanyService
{

    @Resource
    private CompanyDao companyDao;

    public int update(Company company)
    {
        return this.companyDao.update(company);
    }

    public Company findCompany()
    {
        return this.companyDao.findCompany();
    }
}