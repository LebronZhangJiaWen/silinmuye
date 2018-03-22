package com.muyenet.muye.service.picture.impl;

import com.muyenet.muye.dao.picture.IPictureAlbumFavorDao;
import com.muyenet.muye.model.picture.PictureAlbumFavor;
import com.muyenet.muye.service.picture.IPictureAlbumFavorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author zchuanzhao
 * @date 2017/11/17
 */
@Service("pictureAlbumFavorService")
public class PictureAlbumFavorServiceImpl implements IPictureAlbumFavorService {
    @Resource
    private IPictureAlbumFavorDao pictureAlbumFavorDao;


    @Override
    public PictureAlbumFavor find(Integer pictureAlbumId, Integer memberId) {
        return pictureAlbumFavorDao.find(pictureAlbumId,memberId);
    }

    @Override
    public void save(Integer pictureAlbumId, Integer memberId) {
        pictureAlbumFavorDao.save(pictureAlbumId,memberId);
    }

    @Override
    public void delete(Integer pictureAlbumId, Integer memberId) {
        pictureAlbumFavorDao.delete(pictureAlbumId,memberId);
    }
}
