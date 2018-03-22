package com.muyenet.muye.service.picture.impl;

import com.muyenet.muye.dao.picture.IPictureFavorDao;
import com.muyenet.muye.model.picture.PictureFavor;
import com.muyenet.muye.service.picture.IPictureFavorService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created by zchuanzhao on 2017/11/16.
 */
@Service("pictureFavorService")
public class PictureFavorServiceImpl implements IPictureFavorService {
    @Resource
    private IPictureFavorDao pictureFavorDao;


    @Override
    public PictureFavor find(Integer pictureId, Integer memberId) {
        return pictureFavorDao.find(pictureId,memberId);
    }

    @Override
    public void save(Integer pictureId, Integer memberId) {
        pictureFavorDao.save(pictureId,memberId);
    }

    @Override
    public void delete(Integer pictureId, Integer memberId) {
        pictureFavorDao.delete(pictureId,memberId);
    }
}
