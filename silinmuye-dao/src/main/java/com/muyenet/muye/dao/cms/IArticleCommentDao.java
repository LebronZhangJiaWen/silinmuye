package com.muyenet.muye.dao.cms;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.model.cms.ArticleComment;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 文章评论DAO接口
 * Created by zchuanzhao on 2016/11/26.
 */
public interface IArticleCommentDao extends IBaseDao<ArticleComment> {

    List<ArticleComment> listByArticle(@Param("page") Page page, @Param("articleId") Integer articleId);

    int deleteByArticle(@Param("articleId") Integer articleId);
}