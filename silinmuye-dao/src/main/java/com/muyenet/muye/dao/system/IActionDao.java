package com.muyenet.muye.dao.system;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.system.Action;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionDao extends IBaseDao<Action> {
    int isenable(@Param("id") Integer id);
}
