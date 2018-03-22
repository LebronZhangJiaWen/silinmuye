package com.muyenet.muye.service.member.impl;

import com.muyenet.muye.dao.member.IMemberTokenDao;
import com.muyenet.muye.model.member.MemberToken;
import com.muyenet.muye.service.member.IMemberTokenService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zchuanzhao on 16/9/29.
 */
@Service("memberTokenService")
public class MemberTokenServiceImpl implements IMemberTokenService {
    @Resource
    private IMemberTokenDao memberTokenDao;

    @Override
    public MemberToken getByToken(String token) {
        return memberTokenDao.getByToken(token);
    }

    @Override
    public void save(Integer memberId,String token) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.HOUR_OF_DAY,1);
        memberTokenDao.save(memberId,token,calendar.getTime());
    }
}
