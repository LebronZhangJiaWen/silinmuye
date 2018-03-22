package com.muyenet.muye.service.common;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.common.Ads;

/**
 * Created by MMF on 2017-09-07.
 */
public interface IAdsService {
    /**
     * 保存广告信息
     * @param ads
     * @return
     */
    ResponseModel save(Ads ads);
    /**
     * 分页查询广告信息
     * @param page
     * @return
     */
    ResponseModel listByPage(Page page);

    ResponseModel update(Ads ads);

    ResponseModel delete(Integer id);

    Ads findById(Integer id);

    ResponseModel enable(Integer id);

    ResponseModel listHomeAds();
}
