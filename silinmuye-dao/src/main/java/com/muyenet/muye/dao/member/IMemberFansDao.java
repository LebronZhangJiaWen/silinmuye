package com.muyenet.muye.dao.member;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.member.MemberFans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/16.
 */
public interface IMemberFansDao extends IBaseDao<MemberFans> {

    List<MemberFans> followsList(@Param("page") Page page, @Param("whoFollowId") Integer whoFollowId);

    List<MemberFans> fansList(@Param("page") Page page, @Param("followWhoId") Integer followWhoId);

    MemberFans find(@Param("whoFollowId") Integer whoFollowId, @Param("followWhoId") Integer followWhoId);

    Integer save(@Param("whoFollowId") Integer whoFollowId, @Param("followWhoId") Integer followWhoId);

    Integer delete(@Param("whoFollowId") Integer whoFollowId, @Param("followWhoId") Integer followWhoId);
}