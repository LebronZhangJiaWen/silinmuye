package com.muyenet.muye.service.group;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.group.GroupFans;
import com.muyenet.muye.model.member.Member;
import org.apache.ibatis.annotations.Param;


/**
 * Created by zchuanzhao on 16/12/26.
 */
public interface IGroupFansService {

    ResponseModel save(Member loginMember, Integer groupId);

    ResponseModel delete(Member loginMember, Integer groupId);

    ResponseModel listByPage(Page page, Integer groupId);

    GroupFans findByMemberAndGroup(@Param("groupId") Integer groupId, @Param("memberId") Integer memberId);

    /**
     * 获取用户关注的群组列表
     * @param page
     * @param memberId
     * @return
     */
    ResponseModel listByMember(Page page, Integer memberId);
}
