package com.muyenet.muye.service.picture;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.picture.PictureAlbumComment;


/**
 *
 * @author zchuanzhao
 * @date 2017/11/17
 */
public interface IPictureAlbumCommentService {

    PictureAlbumComment findById(int id);

    ResponseModel save(Member loginMember, String content, Integer pictureAlbumId);

    ResponseModel delete(Member loginMember, int id);

    ResponseModel listByPictureAlbum(Page page, int pictureAlbumId);

    void deleteByPictureAlbum(Integer pictureAlbumId);
}
