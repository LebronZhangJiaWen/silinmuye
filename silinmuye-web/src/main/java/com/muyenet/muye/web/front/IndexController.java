package com.muyenet.muye.web.front;

import com.muyenet.muye.model.company.Company;
import com.muyenet.muye.service.cms.IArticleService;
import com.muyenet.muye.service.common.IAdsService;
import com.muyenet.muye.service.common.IArchiveService;
import com.muyenet.muye.common.utils.EmojiUtil;
import com.muyenet.muye.common.utils.MemberUtil;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.core.utils.Const;
import com.muyenet.muye.core.utils.ErrorUtil;
import com.muyenet.muye.core.utils.MuyeConfig;
import com.muyenet.muye.service.common.ILinkService;
import com.muyenet.muye.service.company.CompanyService;
import com.muyenet.muye.service.group.IGroupFansService;
import com.muyenet.muye.service.group.IGroupService;
import com.muyenet.muye.service.group.IGroupTopicService;
import com.muyenet.muye.service.member.IMemberFansService;
import com.muyenet.muye.web.common.BaseController;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.service.member.IMemberService;
import com.muyenet.muye.model.system.ActionLog;
import com.muyenet.muye.service.system.IActionLogService;
import com.muyenet.muye.service.weibo.IWeiboService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zchuanzhao on 2016/11/25.
 */
@Controller("indexController")
@RequestMapping("/")
public class IndexController extends BaseController {
    @Resource
    private IArticleService articleService;
    @Resource
    private IGroupTopicService groupTopicService;
    @Resource
    private IGroupService groupService;
    @Resource
    private IWeiboService weiboService;
    @Resource
    private IMemberService memberService;
    @Resource
    private IArchiveService archiveService;
    @Resource
    private IActionLogService actionLogService;
    @Resource
    private MuyeConfig muyeConfig;
    @Resource
    private IGroupFansService groupFansService;
    @Resource
    private IMemberFansService memberFansService;
    @Resource
    private ILinkService linkService;
    @Resource
    private IAdsService adsService;
    @Resource
    private CompanyService companyService;

    @RequestMapping(value={"/", "index"},method = RequestMethod.GET)
    public String index(@RequestParam(value = "key",required = false,defaultValue = "") String key, Integer cateid,Model model) {
        Page page = new Page(request);
        if(cateid == null){
            cateid = 0;
        }
        Member loginMember = MemberUtil.getLoginMember(request);
        int loginMemberId = loginMember == null ? 0 : loginMember.getId();
        ResponseModel articleModel = articleService.listByPage(page,key,cateid,1,0);
        ResponseModel groupTopicModel = groupTopicService.listByPage(page,key,cateid,1,0);
        ResponseModel groupModel = groupService.listByPage(1,page,key);
        ResponseModel linkModel = linkService.recommentList();
        ResponseModel adsModel = adsService.listHomeAds();
        page.setPageSize(50);
        ResponseModel weiboModel = weiboService.listByPage(page,0,loginMemberId,"");
        Company company = companyService.findCompany();
        model.addAttribute("company",company);
        model.addAttribute("articleModel",articleModel);
        model.addAttribute("groupTopicModel",groupTopicModel);
        model.addAttribute("groupModel",groupModel);
        model.addAttribute("weiboModel",weiboModel);
        model.addAttribute("linkModel",linkModel);
        model.addAttribute("adsModel",adsModel);

        return muyeConfig.getFrontTemplate() + "/index";
    }

    @RequestMapping(value = "u/{id}",method = RequestMethod.GET)
    public String u(@PathVariable("id") Integer id, Model model){
        Page page = new Page(request);
        Member member = memberService.findById(id);
        if(member == null){
            return muyeConfig.getFrontTemplate() + ErrorUtil.error(model,-1005, Const.INDEX_ERROR_FTL_PATH);
        }
        model.addAttribute("member",member);
        Member loginMember = MemberUtil.getLoginMember(request);
        model.addAttribute("loginMember", loginMember);
        ResponseModel<ActionLog> list = actionLogService.memberActionLog(page,id);
        model.addAttribute("actionLogModel",list);
        return muyeConfig.getFrontTemplate() + "/u";
    }

    @RequestMapping(value = "u/{id}/home/{type}",method = RequestMethod.GET)
    public String home(@PathVariable("id") Integer id, @PathVariable("type") String type, Model model){
        Page page = new Page(request);
        Member member = memberService.findById(id);
        if(member == null){
            return muyeConfig.getFrontTemplate() + ErrorUtil.error(model,-1005, Const.INDEX_ERROR_FTL_PATH);
        }
        model.addAttribute("member",member);

        Member loginMember = MemberUtil.getLoginMember(request);
        model.addAttribute("loginMember", loginMember);
        int loginMemberId = 0;
        if(loginMember != null){
            loginMemberId = loginMember.getId().intValue();
        }
        if("article".equals(type)){
            model.addAttribute("model", articleService.listByPage(page,"",0,1, id));
        } else if("groupTopic".equals(type)){
            model.addAttribute("model", groupTopicService.listByPage(page,"",0,1, id));
        } else if("group".equals(type)){
            model.addAttribute("model", groupFansService.listByMember(page, id));
        } else if("weibo".equals(type)){
            model.addAttribute("model", weiboService.listByPage(page,id,loginMemberId,""));
        } else if("follows".equals(type)){
            model.addAttribute("model", memberFansService.followsList(page,id));
        } else if("fans".equals(type)){
            model.addAttribute("model", memberFansService.fansList(page,id));
        }
        model.addAttribute("type",type);
        return muyeConfig.getFrontTemplate() + "/home";
    }


    @RequestMapping(value = "newVersion",method = RequestMethod.GET)
    public void newVersion(@RequestParam("callback") String callback){
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("LAST_SYSTEM_VERSION",Const.LAST_SYSTEM_VERSION);
        jsonObject.put("LAST_SYSTEM_UPDATE_TIME", Const.LAST_SYSTEM_UPDATE_TIME);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.print(callback + "(" + jsonObject.toString() + ")");
        out.flush();
        out.close();
    }
    /**
     * 获取Emoji数据
     * @return
     */
    @RequestMapping(value="/emoji/emojiJsonData.json",method = RequestMethod.GET)
    @ResponseBody
    public Object emojiJsonData(){
        return EmojiUtil.emojiJson();
    }

    @RequestMapping(value="/404",method = RequestMethod.GET)
    public String muye404(){
        return muyeConfig.getFrontTemplate() + "/common/404";
    }

    @RequestMapping(value="/error",method = RequestMethod.GET)
    public String error(){
        return muyeConfig.getFrontTemplate() + "/common/error";
    }

    /**
     * 友情链接
     * @param model
     * @return
     */
    @RequestMapping(value={"/link"},method = RequestMethod.GET)
    public String link(Model model) {
        ResponseModel linkModel = linkService.allList();
        model.addAttribute("linkModel",linkModel);
        return muyeConfig.getFrontTemplate() + "/link";
    }
}
