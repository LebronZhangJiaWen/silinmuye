package com.muyenet.muye.web.front;

import com.muyenet.muye.common.utils.MemberUtil;
import com.muyenet.muye.interceptor.UserLoginInterceptor;
import com.muyenet.muye.core.annotation.Before;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.web.common.BaseController;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.member.ScoreDetail;
import com.muyenet.muye.service.member.IScoreDetailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2017/4/7.
 */
@Controller("scoreDetailFrontController")
@RequestMapping("/member/scoreDetail")
@Before(UserLoginInterceptor.class)
public class ScoreDetailController extends BaseController {
    private static final String INDEX_FTL_PATH = "/member/scoreDetail/";
    @Resource
    private IScoreDetailService scoreDetailService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        Page page = new Page(request);
        ResponseModel<ScoreDetail> responseModel = scoreDetailService.list(page,loginMember.getId());
        model.addAttribute("model",responseModel);
        return INDEX_FTL_PATH + "list";
    }
}
