package com.muyenet.muye.dao.picture;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.picture.PictureFavor;
import org.apache.ibatis.annotations.Param;

public interface IPictureFavorDao extends IBaseDao<PictureFavor> {

    PictureFavor find(@Param("pictureId") Integer pictureId, @Param("memberId") Integer memberId);

    Integer save(@Param("pictureId") Integer pictureId, @Param("memberId") Integer memberId);

    Integer delete(@Param("pictureId") Integer pictureId, @Param("memberId") Integer memberId);
}