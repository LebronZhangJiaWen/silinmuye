package com.muyenet.muye.dao.company;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.company.Company;

/**
 * 公司信息接口接口
 * Created by zchuanzhao on 2016/11/26.
 */
public interface CompanyDao extends IBaseDao<Company> {
    Company findCompany();

}