package com.muyenet.muye.service.system;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.system.ActionLog;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionLogService {

    ResponseModel<ActionLog> listByPage(Page page, Integer memberId);

    ResponseModel<ActionLog> memberActionLog(Page page, Integer memberId);

    ActionLog findById(Integer id);

    void save(String actionIp,Integer memberId, Integer actionId);

    void save(String actionIp,Integer memberId, Integer actionId,String remark);

    void save(String actionIp,Integer memberId, Integer actionId,String remark, Integer type, Integer foreignId);

}
