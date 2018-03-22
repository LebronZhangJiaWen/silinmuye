package com.muyenet.muye.service.common;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.common.Link;

/**
 * Created by zchuanzhao on 2017-10-13.
 */
public interface ILinkService {
   
    ResponseModel save(Link link);
   
    ResponseModel listByPage(Page page);

    ResponseModel allList();

    ResponseModel recommentList();

    ResponseModel update(Link link);

    ResponseModel delete(Integer id);

    Link findById(Integer id);

    ResponseModel enable(Integer id);
}
