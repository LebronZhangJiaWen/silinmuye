package com.muyenet.muye.service.company;


import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.model.cms.ArticleCate;
import com.muyenet.muye.model.company.Company;

import java.util.List;


/**
 * Created by zchuanzhao on 16/9/29.
 */
public interface CompanyService {



    int update(Company company);
    Company findCompany();

}
