package com.muyenet.muye.web.company;

import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.core.utils.MuyeConfig;
import com.muyenet.muye.core.utils.StringUtils;
import com.muyenet.muye.model.company.Company;
import com.muyenet.muye.service.company.CompanyService;
import com.muyenet.muye.web.common.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

/**
 * 四林木业公司相关Controller
 * Created by zchuanzhao on 16/9/29.
 */
@Controller("companyController")
@RequestMapping("/silin")
public class CompanyController extends BaseController {
    @Resource
    private MuyeConfig muyeConfig;
    @Resource
    private CompanyService companyService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String list(String key, Model model) {
        if (StringUtils.isNotEmpty(key)){
            try {
                key = new String(key.getBytes("iso-8859-1"),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        Page page = new Page(request);
        Company company = companyService.findCompany();
        model.addAttribute("company",company);
        return muyeConfig.getFrontTemplate() + "/silin/list";
    }

}
