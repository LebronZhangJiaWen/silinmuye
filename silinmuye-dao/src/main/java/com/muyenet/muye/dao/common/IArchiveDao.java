package com.muyenet.muye.dao.common;

import com.muyenet.muye.model.common.Archive;
import org.apache.ibatis.annotations.Param;

/**
 * 文章DAO接口
 * Created by zchuanzhao on 2016/9/26.
 */
public interface IArchiveDao extends IBaseDao<Archive> {

    Archive findByArchiveId(@Param("archiveId") Integer archiveId);

    /**
     * 更新阅读数
     * @param archiveId
     * @return
     */
    int updateViewCount(@Param("archiveId") int archiveId);
    int findByArchiveTitle(@Param("title")String title);

    int favor(@Param("archiveId") int archiveId, @Param("num") int num);
    
}