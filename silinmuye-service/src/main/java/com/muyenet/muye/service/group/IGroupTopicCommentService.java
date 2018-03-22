package com.muyenet.muye.service.group;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.group.GroupTopicComment;
import com.muyenet.muye.model.member.Member;


/**
 * Created by zchuanzhao on 2016/12/27.
 */
public interface IGroupTopicCommentService {

    GroupTopicComment findById(int id);

    ResponseModel save(Member loginMember, String content, Integer groupTopicId, Integer commentId);

    ResponseModel delete(Member loginMember,int id);

    ResponseModel listByGroupTopic(Page page, int groupTopicId);

    void deleteByTopic(int groupTopicId);
}
