package com.muyenet.muye.listener;

import com.muyenet.muye.core.utils.Const;
import com.muyenet.muye.core.utils.MuyeConfig;
import com.muyenet.muye.core.utils.SpringContextHolder;
import com.muyenet.muye.model.system.Config;
import com.muyenet.muye.service.system.IConfigService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * Created by zchuanzhao on 2017/5/25.
 */
public class InitListener implements ServletContextListener {

    public InitListener() {
    }


    public void contextInitialized(ServletContextEvent sce) {
        try {
            Const.PROJECT_PATH = sce.getServletContext().getContextPath();
            sce.getServletContext().setAttribute("basePath", Const.PROJECT_PATH);
            MuyeConfig muyeConfig = SpringContextHolder.getBean("muyeConfig");
            sce.getServletContext().setAttribute("muyeConfig",muyeConfig);
            String frontTemplate = muyeConfig.getFrontTemplate();
            sce.getServletContext().setAttribute("frontTemplate",frontTemplate);
            String managePath = Const.PROJECT_PATH + "/" + muyeConfig.getManagePath();
            sce.getServletContext().setAttribute("managePath",managePath);
            IConfigService configService = SpringContextHolder.getBean("configService");
            List<Config> configList = configService.allList();
            for (Config config : configList) {
                sce.getServletContext().setAttribute(config.getJkey().toUpperCase(),config.getJvalue());
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
