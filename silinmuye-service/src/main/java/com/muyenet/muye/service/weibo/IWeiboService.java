package com.muyenet.muye.service.weibo;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.weibo.Weibo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
public interface IWeiboService {

    Weibo findById(int id, int memberId);

    ResponseModel save(HttpServletRequest request, Member loginMember, String content, String pictures);

    ResponseModel<Weibo> listByPage(Page page, int memberId, int loginMemberId, String key);

    ResponseModel delete(HttpServletRequest request, Member loginMember, int id);

    ResponseModel userDelete(HttpServletRequest request, Member loginMember, int id);

    List<Weibo> hotList(int loginMemberId);

    ResponseModel favor(Member loginMember, int weiboId);

    List<Weibo> listByCustom(int loginMemberId, String sort,int num,int day);
}
