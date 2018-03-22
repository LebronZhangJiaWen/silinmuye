package com.muyenet.muye.service.system;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.model.system.ScoreRule;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IScoreRuleService {

    List<ScoreRule> list();

    ScoreRule findById(Integer id);

    ResponseModel update(ScoreRule scoreRule);

    ResponseModel enabled(int id);

}
