package com.muyenet.muye.dao.group;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.group.GroupTopicComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zchuanzhao on 16/12/27.
 */
public interface IGroupTopicCommentDao extends IBaseDao<GroupTopicComment> {

    List<GroupTopicComment> listByGroupTopic(@Param("page") Page page, @Param("groupTopicId") Integer groupTopicId);

    int deleteByTopic(@Param("groupTopicId") Integer groupTopicId);
}