package com.muyenet.muye.service.group.impl;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.group.Group;
import com.muyenet.muye.model.group.GroupFans;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.service.group.IGroupFansService;
import com.muyenet.muye.dao.group.IGroupFansDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2016/12/26.
 */
@Service("groupFansService")
public class GroupFansServiceImpl implements IGroupFansService {
    @Resource
    private IGroupFansDao groupFansDao;

    @Override
    public ResponseModel listByPage(Page page, Integer groupId) {
        List<GroupFans> list = groupFansDao.listByPage(page, groupId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

    @Override
    public GroupFans findByMemberAndGroup(@Param("groupId") Integer groupId, @Param("memberId") Integer memberId) {
        return groupFansDao.findByMemberAndGroup(groupId,memberId);
    }

    /**
     * 关注
     * @param loginMember
     * @param groupId
     * @return
     */
    @Override
    public ResponseModel save(Member loginMember, Integer groupId) {
        if(groupFansDao.findByMemberAndGroup(groupId,loginMember.getId()) == null){
            if(groupFansDao.save(groupId,loginMember.getId()) == 1){
                return new ResponseModel(1,"关注成功");
            }
        }else {
            //已经关注了
            return new ResponseModel(0,"关注成功");
        }
        return new ResponseModel(-1,"关注失败");
    }

    /**
     * 取消关注
     * @param loginMember
     * @param groupId
     * @return
     */
    @Override
    public ResponseModel delete(Member loginMember,Integer groupId) {
        if(groupFansDao.delete(groupId,loginMember.getId()) > 0){
            return new ResponseModel(1,"取消关注成功");
        }
        return new ResponseModel(-1,"取消关注失败");
    }


    @Override
    public ResponseModel listByMember(Page page, Integer memberId) {
        List<Group> list = groupFansDao.listByMember(page, memberId);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

}
