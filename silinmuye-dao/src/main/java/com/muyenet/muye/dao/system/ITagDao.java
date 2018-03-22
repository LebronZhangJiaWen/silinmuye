package com.muyenet.muye.dao.system;

import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.system.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ITagDao extends IBaseDao<Tag> {

    /**
     * 分页查询
     *
     * @param page
     * @return
     */
    List<Tag> listByPage(@Param("page") Page page, @Param("funcType") int funcType);

}
