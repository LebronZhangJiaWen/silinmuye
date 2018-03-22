package com.muyenet.muye.interceptor;

import com.muyenet.muye.common.utils.MemberUtil;
import com.muyenet.muye.core.utils.MuyeConfig;
import com.muyenet.muye.core.utils.SpringContextHolder;
import com.muyenet.muye.model.member.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zchuanzhao on 16/11/25.
 */
public class AdminLoginInterceptor implements MuyeInterceptor {

    @Override
    public boolean interceptor(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        Member loginAdmin = MemberUtil.getLoginMember(httpServletRequest);
        if (loginAdmin == null || loginAdmin.getIsAdmin() == 0) {
            MuyeConfig muyeConfig = SpringContextHolder.getBean("muyeConfig");
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/" + muyeConfig.getManagePath() + "/login");
            return false;
        }
        httpServletRequest.setAttribute("loginUser", loginAdmin);
        return true;
    }
}
