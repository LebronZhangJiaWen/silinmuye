package com.muyenet.muye.service.group;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.group.Group;
import com.muyenet.muye.model.member.Member;

import java.util.List;


/**
 * Created by zchuanzhao on 16/12/23.
 */
public interface IGroupService {

    Group findById(int id);

    ResponseModel save(Member loginMember, Group group);

    ResponseModel update(Member loginMember, Group group);

    ResponseModel delete(Member loginMember, int id);

    ResponseModel listByPage(int status, Page page, String key);

    ResponseModel follow(Member loginMember, Integer groupId,int type);

    ResponseModel changeStatus(int id);

    List<Group> listByCustom(int status, int num, String sort);
}
