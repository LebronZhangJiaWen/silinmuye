package com.muyenet.muye.service.member;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.member.MemberFans;


/**
 * Created by zchuanzhao on 17/2/21.
 */
public interface IMemberFansService {

    ResponseModel save(Integer whoFollowId, Integer followWhoId);

    ResponseModel delete(Integer whoFollowId, Integer followWhoId);

    ResponseModel followsList(Page page, Integer whoFollowId);

    ResponseModel fansList(Page page, Integer followWhoId);

    MemberFans find(Integer whoFollowId, Integer followWhoId);
}
