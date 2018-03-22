package com.muyenet.muye.web.front;

import com.muyenet.muye.common.utils.MemberUtil;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.core.utils.Const;
import com.muyenet.muye.core.utils.ErrorUtil;
import com.muyenet.muye.core.utils.MuyeConfig;
import com.muyenet.muye.web.common.BaseController;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.weibo.Weibo;
import com.muyenet.muye.service.weibo.IWeiboCommentService;
import com.muyenet.muye.service.weibo.IWeiboService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2016/12/20.
 */
@Controller("frontWeiboController")
@RequestMapping("/weibo")
public class WeiboController extends BaseController {
    @Resource
    private IWeiboService weiboService;
    @Resource
    private IWeiboCommentService weiboCommentService;
    @Resource
    private MuyeConfig muyeConfig;

    @RequestMapping(value = "/publish",method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel publish(String content,String pictures){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        return weiboService.save(request, loginMember,content, pictures);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "key",required = false,defaultValue = "") String key, Model model){
        Page page = new Page(request);
        Member loginMember = MemberUtil.getLoginMember(request);
        int loginMemberId = loginMember == null ? 0 : loginMember.getId();
        ResponseModel responseModel = weiboService.listByPage(page,0,loginMemberId,key);
        model.addAttribute("model",responseModel);
        List<Weibo> hotList = weiboService.hotList(loginMemberId);
        model.addAttribute("hotList",hotList);
        model.addAttribute("loginUser", loginMember);
        return muyeConfig.getFrontTemplate() + "/weibo/list";
    }

    @RequestMapping(value = "/detail/{weiboId}",method = RequestMethod.GET)
    public String detail(@PathVariable("weiboId") Integer weiboId, Model model){
        Member loginMember = MemberUtil.getLoginMember(request);
        int loginMemberId = loginMember == null ? 0 : loginMember.getId();
        Weibo weibo = weiboService.findById(weiboId,loginMemberId);
        if(weibo == null){
            return muyeConfig.getFrontTemplate() + ErrorUtil.error(model,1007, Const.INDEX_ERROR_FTL_PATH);
        }
        model.addAttribute("weibo",weibo);
        model.addAttribute("loginUser", loginMember);
        return muyeConfig.getFrontTemplate() + "/weibo/detail";
    }

    @RequestMapping(value="/delete/{weiboId}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("weiboId") Integer weiboId){
        Member loginMember = MemberUtil.getLoginMember(request);
        ResponseModel responseModel = weiboService.userDelete(request, loginMember,weiboId);
        if(responseModel.getCode() >= 0){
            responseModel.setCode(2);
            responseModel.setUrl(request.getContextPath() + "/weibo/list");
        }
        return responseModel;
    }


    @RequestMapping(value="/comment/{weiboId}",method = RequestMethod.POST)
    @ResponseBody
    public Object comment(@PathVariable("weiboId") Integer weiboId, String content, Integer weiboCommentId){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        return weiboCommentService.save(loginMember,content,weiboId,weiboCommentId);
    }

    @RequestMapping(value="/commentList/{weiboId}.json",method = RequestMethod.GET)
    @ResponseBody
    public Object commentList(@PathVariable("weiboId") Integer weiboId){
        Page page = new Page(request);
        if(weiboId == null){
            weiboId = 0;
        }
        return weiboCommentService.listByWeibo(page,weiboId);
    }

    @RequestMapping(value="/favor/{weiboId}",method = RequestMethod.GET)
    @ResponseBody
    public Object favor(@PathVariable("weiboId") Integer weiboId){
        Member loginMember = MemberUtil.getLoginMember(request);
        if(loginMember == null){
            return new ResponseModel(-1,"请先登录");
        }
        if(weiboId == null) {
            return new ResponseModel(-1, "非法操作");
        }
        return weiboService.favor(loginMember,weiboId);
    }
}
