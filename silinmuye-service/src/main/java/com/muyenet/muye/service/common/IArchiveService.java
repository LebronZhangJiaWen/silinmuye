package com.muyenet.muye.service.common;

import com.muyenet.muye.model.common.Archive;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.model.member.Member;
import org.apache.ibatis.annotations.Param;


/**
 * Created by zchuanzhao on 2016/10/14.
 */
public interface IArchiveService {

    Archive findByArchiveId(int id);

    boolean save(Member member, Archive archive);

    boolean update(Member member, Archive archive);
    int findByArchiveTitle(String title);
    boolean delete(int id);

    void updateViewCount(int id);

    ResponseModel favor(Member loginMember, int archiveId);
}
