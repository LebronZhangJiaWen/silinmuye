package com.muyenet.muye.dao.picture;

import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.picture.PictureAlbumComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPictureAlbumCommentDao extends IBaseDao<PictureAlbumComment> {
    List<PictureAlbumComment> listByPictureAlbum(@Param("page") Page page, @Param("pictureAlbumId") Integer pictureAlbumId);

    int deleteByPictureAlbum(@Param("pictureAlbumId") Integer pictureAlbumId);
}