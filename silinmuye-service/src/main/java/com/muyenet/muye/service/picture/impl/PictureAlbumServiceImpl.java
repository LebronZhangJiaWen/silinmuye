package com.muyenet.muye.service.picture.impl;

import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.core.utils.Const;
import com.muyenet.muye.core.utils.StringUtils;
import com.muyenet.muye.dao.picture.IPictureAlbumDao;
import com.muyenet.muye.model.picture.PictureAlbum;
import com.muyenet.muye.service.picture.IPictureAlbumService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2017/3/7.
 */
@Service
public class PictureAlbumServiceImpl implements IPictureAlbumService {
    @Resource
    private IPictureAlbumDao pictureAlbumDao;

    @Override
    public ResponseModel listByMember(Integer memberId) {
        List<PictureAlbum> list = pictureAlbumDao.listByMember(memberId);
        ResponseModel model = new ResponseModel(0);
        model.setData(list);
        return model;
    }

    @Override
    public ResponseModel<PictureAlbum> listByPage(Page page) {
        List<PictureAlbum> list = pictureAlbumDao.listByPage(page);
        ResponseModel model = new ResponseModel(0, page);
        model.setData(list);
        return model;
    }

    @Override
    public ResponseModel delete(Integer id) {
        if (pictureAlbumDao.delete(id) > 0) {
            return new ResponseModel(0, "删除成功");
        }
        return new ResponseModel(-1, "删除失败");
    }

    @Override
    public ResponseModel save(PictureAlbum pictureAlbum) {
        if (pictureAlbum.getType() == null){
            pictureAlbum.setType(0);
        }
        if (StringUtils.isEmpty(pictureAlbum.getCover())){
            pictureAlbum.setCover(Const.DEFAULT_PICTURE_COVER);
        }
        if (pictureAlbumDao.save(pictureAlbum) > 0) {
            return new ResponseModel(0, "添加成功");
        }
        return new ResponseModel(-1, "添加失败");
    }

    @Override
    public ResponseModel update(PictureAlbum pictureAlbum) {
        if (pictureAlbumDao.update(pictureAlbum) > 0) {
            return new ResponseModel(0, "更新成功");
        }
        return new ResponseModel(-1, "更新失败");
    }

    @Override
    public PictureAlbum findWeiboAlbum(Integer memberId) {
        return pictureAlbumDao.findWeiboAlbum(memberId);
    }

    @Override
    public PictureAlbum findById(Integer id) {
        return pictureAlbumDao.findById(id);
    }
}
