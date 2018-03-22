package com.muyenet.muye.dao.weibo;

import com.muyenet.muye.dao.common.IBaseDao;
import com.muyenet.muye.model.weibo.WeiboFavor;
import org.apache.ibatis.annotations.Param;

/**
 * 微博点赞DAO接口
 * Created by zchuanzhao on 2017/2/8.
 */
public interface IWeiboFavorDao extends IBaseDao<WeiboFavor> {

    WeiboFavor find(@Param("weiboId") Integer weiboId, @Param("memberId") Integer memberId);

    Integer save(@Param("weiboId") Integer weiboId, @Param("memberId") Integer memberId);

    Integer delete(@Param("weiboId") Integer weiboId, @Param("memberId") Integer memberId);
}