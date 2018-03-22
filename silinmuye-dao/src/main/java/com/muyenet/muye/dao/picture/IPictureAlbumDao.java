package com.muyenet.muye.dao.picture;

import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.picture.PictureAlbum;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface IPictureAlbumDao extends IBaseDao<PictureAlbum> {

    List<PictureAlbum> listByMember(@Param("memberId") Integer memberId);

    List<PictureAlbum> listByPage(@Param("page") Page page);

    PictureAlbum findWeiboAlbum(@Param("memberId") Integer memberId);
}