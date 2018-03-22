package com.muyenet.muye.dao.picture;

import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.picture.PictureComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPictureCommentDao extends IBaseDao<PictureComment> {

    List<PictureComment> listByPicture(@Param("page") Page page, @Param("pictureId") Integer pictureId);

    int deleteByPicture(@Param("pictureId") Integer pictureId);
}