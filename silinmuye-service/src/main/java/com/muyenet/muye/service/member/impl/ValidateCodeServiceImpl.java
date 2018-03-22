package com.muyenet.muye.service.member.impl;

import com.muyenet.muye.dao.member.IValidateCodeDao;
import com.muyenet.muye.model.member.ValidateCode;
import com.muyenet.muye.service.member.IValidateCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2017/1/20.
 */
@Service("validateCodeService")
public class ValidateCodeServiceImpl implements IValidateCodeService {
    @Resource
    private IValidateCodeDao validateCodeDao;

    @Override
    public boolean save(ValidateCode validateCode) {
        return validateCodeDao.save(validateCode) == 1;
    }

    @Override
    public ValidateCode valid(String email, String code, int type) {
        return validateCodeDao.valid(email,code,type);
    }

    @Override
    public boolean used(Integer id) {
        return validateCodeDao.used(id) == 1;
    }
}
