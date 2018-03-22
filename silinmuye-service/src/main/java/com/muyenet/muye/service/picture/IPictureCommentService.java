package com.muyenet.muye.service.picture;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.model.picture.PictureComment;


/**
 * Created by zchuanzhao on 2017/11/14.
 */
public interface IPictureCommentService {

    PictureComment findById(int id);

    ResponseModel save(Member loginMember, String content, Integer pictureId);

    ResponseModel delete(Member loginMember, int id);

    ResponseModel listByPicture(Page page, int pictureId);

    void deleteByPicture(Integer pictureId);
}
