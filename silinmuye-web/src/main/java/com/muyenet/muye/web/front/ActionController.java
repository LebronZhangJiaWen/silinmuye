package com.muyenet.muye.web.front;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.core.utils.MuyeConfig;
import com.muyenet.muye.web.common.BaseController;
import com.muyenet.muye.model.system.ActionLog;
import com.muyenet.muye.service.system.IActionLogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * 动态
 * Created by zchuanzhao on 2017/3/8.
 */
@Controller("frontActionController")
@RequestMapping("/action/")
public class ActionController extends BaseController {
    @Resource
    private IActionLogService actionLogService;
    @Resource
    private MuyeConfig muyeConfig;

    @RequestMapping("list")
    public String list(Model model){
        Page page = new Page(request);
        ResponseModel<ActionLog> actionList = actionLogService.memberActionLog(page,0);
        model.addAttribute("model", actionList);
        return muyeConfig.getFrontTemplate() + "/action/list";
    }


}
