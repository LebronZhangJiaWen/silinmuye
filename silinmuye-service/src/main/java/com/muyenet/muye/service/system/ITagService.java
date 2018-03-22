package com.muyenet.muye.service.system;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.system.Tag;

public interface ITagService {
    ResponseModel save(Tag tag);

    ResponseModel listByPage(Page page,int funcType);

    ResponseModel update(Tag tag);

    ResponseModel delete(Integer id);

    Tag findById(Integer id);

}
