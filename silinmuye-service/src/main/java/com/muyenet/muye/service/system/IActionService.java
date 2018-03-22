package com.muyenet.muye.service.system;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.model.system.Action;

import java.util.List;

/**
 * Created by zchuanzhao on 2017/2/14.
 */
public interface IActionService {

    List<Action> list();

    Action findById(Integer id);

    ResponseModel update(Action action);

    ResponseModel isenable(Integer id);

    boolean canuse(Integer id);
}
