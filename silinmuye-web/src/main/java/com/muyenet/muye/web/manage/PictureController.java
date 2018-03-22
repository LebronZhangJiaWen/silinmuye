package com.muyenet.muye.web.manage;

import com.muyenet.muye.core.annotation.Before;
import com.muyenet.muye.core.consts.AppTag;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.interceptor.AdminLoginInterceptor;
import com.muyenet.muye.service.picture.IPictureService;
import com.muyenet.muye.service.system.ITagService;
import com.muyenet.muye.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 * @author zchuanzhao
 * @date 2017/11/01
 */
@Controller
@RequestMapping("/${managePath}/picture")
@Before(AdminLoginInterceptor.class)
public class PictureController extends BaseController{
    private static final String MANAGE_FTL_PATH = "/manage/picture/";
    @Resource
    private IPictureService pictureService;
    @Resource
    private ITagService tagService;

    @RequestMapping("/tagList")
    public String tagList(Model model){
        Page page = new Page(request);
        ResponseModel responseModel = tagService.listByPage(page, AppTag.PICTURE);
        model.addAttribute("model",responseModel);
        return MANAGE_FTL_PATH + "tagList";
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        Page page = new Page(request);
        ResponseModel responseModel = pictureService.listByPage(page,0);
        model.addAttribute("model",responseModel);
        return MANAGE_FTL_PATH + "list";
    }

    @RequestMapping(value = "/delete/{pictureId}",method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@PathVariable("pictureId") Integer pictureId){
        return pictureService.delete(request,pictureId);
    }

}
