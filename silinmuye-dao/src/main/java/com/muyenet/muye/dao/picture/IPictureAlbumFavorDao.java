package com.muyenet.muye.dao.picture;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.picture.PictureAlbumFavor;
import org.apache.ibatis.annotations.Param;

public interface IPictureAlbumFavorDao extends IBaseDao<PictureAlbumFavor> {
    PictureAlbumFavor find(@Param("pictureAlbumId") Integer pictureAlbumId, @Param("memberId") Integer memberId);

    Integer save(@Param("pictureAlbumId") Integer pictureAlbumId, @Param("memberId") Integer memberId);

    Integer delete(@Param("pictureAlbumId") Integer pictureAlbumId, @Param("memberId") Integer memberId);
}