package com.muyenet.muye.directive;

import com.muyenet.muye.common.utils.MemberUtil;
import com.muyenet.muye.core.directive.BaseDirective;
import com.muyenet.muye.core.handler.DirectiveHandler;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.weibo.Weibo;
import com.muyenet.muye.service.weibo.IWeiboService;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by zchuanzhao on 2017/5/18.
 */
@Component
public class WeiboDirective extends BaseDirective {
    @Resource
    private HttpServletRequest request;

    @Resource
    private IWeiboService weiboService;
    @Override
    public void execute(DirectiveHandler handler) throws TemplateException, IOException {
        int num = handler.getInteger("num",0);
        String sort = handler.getString("sort","id");
        int day = handler.getInteger("day",0);
        Member loginMember = MemberUtil.getLoginMember(request);
        int loginMemberId = loginMember == null ? 0 : loginMember.getId();
        List<Weibo> list = weiboService.listByCustom(loginMemberId,sort,num,day);
        handler.put("weiboList", list).render();
    }

}
