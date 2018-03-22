package com.muyenet.muye.service.picture;


import com.muyenet.muye.model.picture.PictureFavor;

/**
 * 图片点赞Service接口
 * Created by zchuanzhao on 2017/11/16.
 */
public interface IPictureFavorService {

    PictureFavor find(Integer pictureId, Integer memberId);

    void save(Integer pictureId, Integer memberId);

    void delete(Integer pictureId, Integer memberId);
}