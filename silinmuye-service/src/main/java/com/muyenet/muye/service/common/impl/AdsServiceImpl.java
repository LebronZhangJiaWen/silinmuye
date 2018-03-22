package com.muyenet.muye.service.common.impl;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.dao.common.IAdsDao;
import com.muyenet.muye.model.common.Ads;
import com.muyenet.muye.service.common.IAdsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by MMF on 2017-09-07.
 */
@Service("adsService")
public class AdsServiceImpl implements IAdsService {
    @Resource
    private IAdsDao adsDao;

    /**
     * 保存广告信息
     *
     * @param ads
     * @return
     */
    @Override
    public ResponseModel save(Ads ads) {
        if (adsDao.save(ads) == 1) {
            return new ResponseModel(0, "保存成功");
        }
        return new ResponseModel(-1, "保存失败");
    }

    @Override
    public ResponseModel listByPage(Page page) {
        List<Ads> list = adsDao.listByPage(page);
        ResponseModel model = new ResponseModel(0, page);
        model.setData(list);
        return model;
    }

    @Override
    public ResponseModel update(Ads ads) {
        Ads findAds = this.findById(ads.getId());
        if (findAds == null){
            return new ResponseModel(-1, "广告不存在");
        }
        if (adsDao.update(ads) > 0) {
            return new ResponseModel(0, "更新成功");
        }
        return new ResponseModel(-1, "更新失败");
    }

    @Override
    public ResponseModel delete(Integer id) {
        if (adsDao.delete(id) > 0) {
            return new ResponseModel(1, "删除成功");
        }
        return new ResponseModel(-1, "删除失败");
    }

    @Override
    public Ads findById(Integer id) {
        return adsDao.findById(id);
    }

    @Override
    public ResponseModel enable(Integer id) {
        if (adsDao.enable(id) == 1){
            return new ResponseModel(1, "操作成功");
        }
        return new ResponseModel(-1, "操作失败");
    }

    @Override
    public ResponseModel listHomeAds() {
        List<Ads> list = adsDao.listHomeAds();
        ResponseModel model = new ResponseModel(0);
        model.setData(list);
        return model;
    }
}
