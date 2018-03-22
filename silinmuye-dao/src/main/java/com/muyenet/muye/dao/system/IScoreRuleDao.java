package com.muyenet.muye.dao.system;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.system.ScoreRule;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zchuanzhao on 2017/3/24.
 */
public interface IScoreRuleDao extends IBaseDao<ScoreRule> {

    int enabled(@Param("id") int id);
}
