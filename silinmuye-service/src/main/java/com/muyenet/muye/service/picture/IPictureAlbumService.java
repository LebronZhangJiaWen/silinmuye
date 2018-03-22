package com.muyenet.muye.service.picture;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.picture.PictureAlbum;

/**
 * Created by zchuanzhao on 2017/11/03.
 */
public interface IPictureAlbumService {

    ResponseModel<PictureAlbum> listByMember(Integer memberId);

    ResponseModel<PictureAlbum> listByPage(Page page);

    ResponseModel delete(Integer id);

    ResponseModel save(PictureAlbum pictureAlbum);

    ResponseModel update(PictureAlbum pictureAlbum);

    PictureAlbum findWeiboAlbum(Integer memberId);

    PictureAlbum findById(Integer id);
}