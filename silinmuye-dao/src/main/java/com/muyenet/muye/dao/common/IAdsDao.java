package com.muyenet.muye.dao.common;

import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.common.Ads;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by MMF on 2017-09-07.
 */
public interface IAdsDao extends IBaseDao<Ads>{

    /**
     * 分页查询广告信息
     * @param page
     * @return
     */
    List<Ads> listByPage(@Param("page") Page page);
    List<Ads> listHomeAds();
    int enable(@Param("id") Integer id);
}
