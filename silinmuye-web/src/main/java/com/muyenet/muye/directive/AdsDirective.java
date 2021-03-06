package com.muyenet.muye.directive;

import com.muyenet.muye.core.directive.BaseDirective;
import com.muyenet.muye.core.handler.DirectiveHandler;
import com.muyenet.muye.model.common.Ads;
import com.muyenet.muye.service.common.IAdsService;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by zchuanzhao on 2017/09/08.
 */
@Component
public class AdsDirective extends BaseDirective {

    @Resource
    private IAdsService adsService;
    @Override
    public void execute(DirectiveHandler handler) throws TemplateException, IOException {
        int id = handler.getInteger("id",0);
        Ads ads = adsService.findById(id);
        handler.put("ad", ads).render();
    }

}
