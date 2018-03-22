package com.muyenet.muye.service.group.impl;

import com.muyenet.muye.core.consts.AppTag;
import com.muyenet.muye.core.enums.MessageType;
import com.muyenet.muye.core.dto.ResponseModel;
import com.muyenet.muye.core.model.Page;
import com.muyenet.muye.core.utils.StringUtils;
import com.muyenet.muye.model.group.GroupTopic;
import com.muyenet.muye.model.group.GroupTopicComment;
import com.muyenet.muye.model.member.Member;
import com.muyenet.muye.service.group.IGroupTopicCommentService;
import com.muyenet.muye.dao.group.IGroupTopicCommentDao;
import com.muyenet.muye.service.group.IGroupTopicService;
import com.muyenet.muye.service.member.IMemberService;
import com.muyenet.muye.service.member.IMessageService;
import com.muyenet.muye.service.member.IScoreDetailService;
import com.muyenet.muye.service.system.IActionLogService;
import com.muyenet.muye.common.utils.ActionUtil;
import com.muyenet.muye.common.utils.ScoreRuleConsts;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zchuanzhao on 2016/12/27.
 */
@Service("groupTopicCommentService")
public class GroupTopicCommentServiceImpl implements IGroupTopicCommentService {
    @Resource
    private IGroupTopicCommentDao groupTopicCommentDao;
    @Resource
    private IGroupTopicService groupTopicService;
    @Resource
    private IActionLogService actionLogService;
    @Resource
    private IScoreDetailService scoreDetailService;
    @Resource
    private IMessageService messageService;
    @Resource
    private IMemberService memberService;

    @Override
    public GroupTopicComment findById(int id) {
        return this.atFormat(groupTopicCommentDao.findById(id));
    }

    @Override
    public ResponseModel save(Member loginMember, String content, Integer groupTopicId, Integer commentId) {
        GroupTopic groupTopic = groupTopicService.findById(groupTopicId,loginMember);
        if(groupTopic == null){
            return new ResponseModel(-1,"帖子不存在");
        }
        if(StringUtils.isEmpty(content)){
            return new ResponseModel(-1,"内容不能为空");
        }
        GroupTopicComment groupTopicComment = new GroupTopicComment();
        groupTopicComment.setMemberId(loginMember.getId());
        groupTopicComment.setGroupTopicId(groupTopicId);
        groupTopicComment.setContent(content);
        groupTopicComment.setCommentId(commentId);
        int result = groupTopicCommentDao.save(groupTopicComment);
        if(result == 1){
            //@会员处理并发送系统消息
            messageService.atDeal(loginMember.getId(),content, AppTag.GROUP, MessageType.GROUP_TOPIC_COMMENT_REFER,groupTopicComment.getId());
            messageService.diggDeal(loginMember.getId(),groupTopic.getMemberId(),content,AppTag.GROUP,MessageType.GROUP_TOPIC_REPLY,groupTopic.getId());
            if (commentId != null){
                GroupTopicComment replyGroupTopicComment = findById(commentId);
                if(replyGroupTopicComment != null){
                    messageService.diggDeal(loginMember.getId(),replyGroupTopicComment.getMemberId(),content,AppTag.GROUP,MessageType.GROUP_TOPIC_REPLY_REPLY,replyGroupTopicComment.getId());
                }
            }
            //群组帖子评论奖励
            scoreDetailService.scoreBonus(loginMember.getId(), ScoreRuleConsts.GROUP_TOPIC_COMMENTS, groupTopicComment.getId());
            return new ResponseModel(1,"评论成功");
        }else {
            return new ResponseModel(-1,"评论失败");
        }
    }

    @Override
    public ResponseModel listByGroupTopic(Page page, int groupTopicId) {
        List<GroupTopicComment> list = groupTopicCommentDao.listByGroupTopic(page, groupTopicId);
        this.atFormat(list);
        ResponseModel model = new ResponseModel(0,page);
        model.setData(list);
        return model;
    }

    @Override
    public void deleteByTopic(int groupTopicId) {
        groupTopicCommentDao.deleteByTopic(groupTopicId);
    }

    @Override
    public ResponseModel delete(Member loginMember,int id){
        GroupTopicComment groupTopicComment = this.findById(id);
        if(groupTopicComment == null){
            return new ResponseModel(-1,"评论不存在");
        }
        int result = groupTopicCommentDao.delete(id);
        if(result == 1){
            //扣除积分
            scoreDetailService.scoreCancelBonus(loginMember.getId(),ScoreRuleConsts.GROUP_TOPIC_COMMENTS,id);
            actionLogService.save(loginMember.getCurrLoginIp(),loginMember.getId(), ActionUtil.DELETE_GROUP_TOPIC_COMMENT,"ID："+groupTopicComment.getId()+"，内容："+groupTopicComment.getContent());
            return new ResponseModel(1,"删除成功");
        }
        return new ResponseModel(-1,"删除失败");
    }

    public GroupTopicComment atFormat(GroupTopicComment groupTopicComment){
        groupTopicComment.setContent(memberService.atFormat(groupTopicComment.getContent()));
        return groupTopicComment;
    }

    public List<GroupTopicComment> atFormat(List<GroupTopicComment> groupTopicCommentList){
        for (GroupTopicComment groupTopicComment : groupTopicCommentList){
            atFormat(groupTopicComment);
        }
        return groupTopicCommentList;
    }
}
