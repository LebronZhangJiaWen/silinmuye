package com.muyenet.muye.dao.system;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.system.ActionLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionLogDao extends IBaseDao<ActionLog> {

    List<ActionLog> listByPage(@Param("page") Page page, @Param("memberId") Integer memberId);

    List<ActionLog> memberActionLog(@Param("page") Page page, @Param("memberId") Integer memberId);
}
