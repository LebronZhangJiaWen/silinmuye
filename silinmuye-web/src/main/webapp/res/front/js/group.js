var group = {
    commentList : function (groupTopicId,pageNo) {
        $.ajax({
            url : base+"/group/commentList/"+groupTopicId+".json?pageNo="+pageNo,
            type : "get",
            dataType: "json",
            success : function (json) {
                var data = json.data;
                var html = "";
                for(var i=0;i<data.length;i++){
                    html += "<div class=\"comment\">" +
                        "<a href=\""+base+"/u/"+data[i].member.id+"\" class=\"avatar\">" +
                        "<img src=\""+base+data[i].member.avatar+"\" class=\"icon-4x\"></a><div class=\"content\">" +
                        "<div class=\"pull-right text-muted\">"+data[i].createTime+"</div><div>" +
                        "<a href=\""+base+"/u/"+data[i].member.id+"\"><strong>"+data[i].member.name+"</strong></a></div>" +
                        "<div class=\"text\">";
                    var groupTopicComment = data[i].groupTopicComment;
                    if (groupTopicComment != null){
                        html += "<pre><code><p>引用“<a href='"+base+"/u/"+groupTopicComment.member.id+"'>"+groupTopicComment.member.name+"</a>”的评论</p>"+groupTopicComment.content+"</code></pre>";
                    }
                    html += data[i].content + "<div class='pull-right'><a href='javascript:group.commentReply("+data[i].id+")'>回复</a></div></div>" +
                        "<form class=\"form-horizontal muye_form\" action=\""+base+"/group/comment/"+groupTopicId+"\" method=\"post\" id='comment-form-"+data[i].id+"' style='display: none;'>" +
                        "<div class=\"form-group\"><input type='hidden' name='groupTopicCommentId' value='"+data[i].id+"'/>" +
                        "<textarea name=\"content\" class=\"form-control group-comment-content\" rows=\"2\" id=\""+data[i].id+"\"></textarea></div>" +
                        "<div class=\"form-group comment-user\">" +
                        "<input type=\"submit\" value=\"回复\" class=\"pull-right btn btn-primary mg-t-10 muye-submit\"></div></form></div></div>";
                }
                pageNo = json.page.pageNo;
                if(json.page.totalPage<=pageNo){
                    $("#moreComment").hide();
                }else {
                    $("#moreComment").show();
                }
                $("#commentList").append(html);
                $('.muye_form').unbind();
                muye.submitForm();
            }
        });
    },
    favor : function (_this,base) {
        var topicId = _this.attr("topic-id");
        $.ajax({
            url: base + "/group/topic/favor/" + topicId,
            type: "get",
            dataType: "json",
            timeout: 5000,
            success: function (res) {
                if (res.code < 0) {
                    muyeDialog.errorTips(res.message);
                } else {
                    if (res.code == 0) {
                        _this.html("<i class='icon-heart'></i> 喜欢 | " + res.data);
                        _this.removeClass("btn-article-unfavor")
                    } else {
                        _this.html("<i class='icon-heart-empty'></i> 喜欢 | " + res.data);
                        _this.addClass("btn-article-unfavor");
                    }
                }
            }
        });
    },
    commentReply: function (id) {
        $('#comment-form-'+id).toggle();
        $('#'+id).focus();
    }
}
