package com.muyenet.muye.service.member;


import com.muyenet.muye.model.member.MemberToken;

/**
 * Created by zchuanzhao on 2017/7/15.
 */
public interface IMemberTokenService {

    MemberToken getByToken(String token);

    void save(Integer memberId,String token);

}