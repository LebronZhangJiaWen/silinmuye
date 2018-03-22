package com.muyenet.muye.service.weibo;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.weibo.WeiboComment;


/**
 * Created by zchuanzhao on 2016/10/14.
 */
public interface IWeiboCommentService {

    WeiboComment findById(int id);

    ResponseModel save(Member loginMember, String content, Integer weiboId, Integer weiboCommentId);

    ResponseModel delete(Member loginMember,int id);

    ResponseModel listByWeibo(Page page, int weiboId);

    void deleteByWeibo(Integer weiboId);
}
