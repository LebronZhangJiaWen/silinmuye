package com.muyenet.muye.service.system;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.model.system.Config;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by zchuanzhao on 16/9/29.
 */
public interface IConfigService {
    List<Config> allList();

    Map<String,String> getConfigToMap();

    String getValue(String key);

    ResponseModel update(Map<String,String> params, HttpServletRequest request);
}
