package com.muyenet.muye.web.manage;

import com.muyenet.muye.common.utils.MemberUtil;
import com.muyenet.muye.core.annotation.Before;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.interceptor.AdminLoginInterceptor;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.service.weibo.IWeiboService;
import com.muyenet.muye.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2016/11/22.
 */
@Controller("mamageWeiboController")
@RequestMapping("/")
@Before(AdminLoginInterceptor.class)
public class WeiboController extends BaseController {
    private static final String MANAGE_FTL_PATH = "/manage/weibo/";
    @Resource
    private IWeiboService weiboService;

    @RequestMapping("${managePath}/weibo/index")
    @Before(AdminLoginInterceptor.class)
    public String index(@RequestParam(value = "key",required = false,defaultValue = "") String key, Model model) {
        Page page = new Page(request);
        ResponseModel responseModel = weiboService.listByPage(page,0,0,key);
        model.addAttribute("model",responseModel);
        return MANAGE_FTL_PATH + "index";
    }

    @RequestMapping(value = "${managePath}/weibo/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("id") int id) {
        Member loginMember = MemberUtil.getLoginMember(request);
        return weiboService.delete(request, loginMember,id);
    }
}
