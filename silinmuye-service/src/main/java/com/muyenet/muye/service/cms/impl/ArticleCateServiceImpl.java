package com.muyenet.muye.service.cms.impl;

import com.muyenet.muye.dao.cms.IArticleDao;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.dao.cms.IArticleCateDao;
import com.muyenet.muye.model.cms.ArticleCate;
import com.muyenet.muye.service.cms.IArticleCateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 16/9/29.
 */
@Service("articleCateService")
public class ArticleCateServiceImpl implements IArticleCateService {

    @Resource
    private IArticleCateDao articleCateDao;
    @Resource
    private IArticleDao articleDao;

    @Override
    public ArticleCate findById(int id) {
        ArticleCate articleCate = articleCateDao.findById(id);
        return articleCate;
    }

    @Override
    public int save(ArticleCate articleCate) {
        return articleCateDao.save(articleCate);
    }

    @Override
    public int update(ArticleCate articleCate) {
        return articleCateDao.update(articleCate);
    }

    @Override
    @Transactional
    public ResponseModel delete(int id) {
        List sonList = this.findListByFid(id);
        if(sonList.size() > 0){
            return new ResponseModel(-1,"请先删除子栏目");
        }
//        articleDao.setArticleAsNoneCate(id);
        int result = articleCateDao.delete(id);

        if(result == 1){
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    @Override
    public List<ArticleCate> list() {
        return articleCateDao.list();
    }

    public List<ArticleCate> findListByFid(int fid) {
        return articleCateDao.findListByFid(fid);
    }

}
