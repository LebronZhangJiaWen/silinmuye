package com.muyenet.muye.web.manage;

import com.muyenet.muye.core.annotation.Before;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.interceptor.AdminLoginInterceptor;
import com.muyenet.muye.model.system.Tag;
import com.muyenet.muye.service.system.ITagService;
import com.muyenet.muye.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2017/10/13.
 */
@Controller
@RequestMapping("/${managePath}/tag")
@Before(AdminLoginInterceptor.class)
public class TagController extends BaseController{
    private static final String MANAGE_FTL_PATH = "/manage/tag/";
    @Resource
    private ITagService tagService;

    @RequestMapping("/list/{funcType}")
    public String list(Model model,@PathVariable("funcType") Integer funcType){
        Page page = new Page(request);
        ResponseModel responseModel = tagService.listByPage(page,funcType);
        model.addAttribute("funcType",funcType);
        model.addAttribute("model",responseModel);
        return MANAGE_FTL_PATH + "list";
    }

    @RequestMapping("/add/{funcType}")
    public String add(Model model,@PathVariable("funcType") Integer funcType){
        model.addAttribute("funcType",funcType);
        return MANAGE_FTL_PATH + "add";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object save(Tag tag){
        ResponseModel responseModel = tagService.save(tag);
        if(responseModel.getCode() == 0){
            responseModel.setCode(3);
        }
        return responseModel;
    }


    @RequestMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Tag tag = tagService.findById(id);
        model.addAttribute("tag",tag);
        return MANAGE_FTL_PATH + "edit";
    }

    @RequestMapping("/update")
    @ResponseBody
    public Object update(Tag tag){
        if (tag == null){
            return new ResponseModel(-1,"参数错误");
        }
        ResponseModel responseModel = tagService.update(tag);
        if(responseModel.getCode() == 0){
            responseModel.setCode(3);
        }
        return responseModel;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Object delete(@PathVariable("id") Integer id){
        return tagService.delete(id);
    }

}
