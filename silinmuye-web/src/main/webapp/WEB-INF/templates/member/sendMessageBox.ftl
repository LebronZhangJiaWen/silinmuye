<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>发送私信 - ${SITE_NAME} - Powered By dingdingzhongyuan</title>
    <meta name="keywords" content="${SITE_KEYS}"/>
    <meta name="description" content="${SITE_DESCRIPTION}"/>
    <meta name="author" content="dingdingzhongyuan"/>
    <link href="${basePath}/res/common/css/bootstrap.min.css" rel="stylesheet">
    <link href="${basePath}/res/common/css/font-awesome.min.css" rel="stylesheet">
    <link href="${basePath}/res/common/css/muye.css" rel="stylesheet">
    <link href="${basePath}/res/common/css/muye-skin.css" rel="stylesheet">
    <link href="${basePath}/res/plugins/emoji/css/emoji.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${basePath}/res/common/js/html5shiv.min.js"></script>
    <script src="${basePath}/res/common/js/respond.min.js"></script>
    <![endif]-->
    <script src="${basePath}/res/common/js/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/res/common/js/bootstrap.min.js"></script>
    <script src="${basePath}/res/plugins/layer/layer.js"></script>
    <script src="${basePath}/res/common/js/jquery.form.js"></script>
    <script src="${basePath}/res/common/js/muye.js"></script>
    <script src="${basePath}/res/modules/weibo.js"></script>
    <script src="${basePath}/res/plugins/emoji/js/underscore-min.js"></script>
    <script src="${basePath}/res/plugins/emoji/js/emojis.js"></script>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="container">
        <div class="row">
            <div class="ibox">
                <div class="ibox-content">
                    <div class="form-group">
                        <div class="col-sm-12">
                            发送私信给：${member.name}
                            <a href="">聊天记录</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <textarea rows="5" class="form-control col-sm-12" id="content"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12" class="form-control">
                            <button type="button" class="btn btn-primary block full-width sendMessage">发送</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function () {
        $(".sendMessage").on("click", function () {
            var content = $("#content").val();
            if (content == "") {
                muyeDialog.errorTips("请输入私信内容");
                return;
            }
            $.ajax({
                url: "${basePath}/member/sendMessage",
                type: "post",
                data: {
                    memberId:${member.id},
                    content: content
                },
                cache: false,
                dataType: "json",
                timeout: 5000,
                beforeSend: function () {
                    index = muyeDialog.loading();
                },
                error: function () {
                    muyeDialog.close(index);
                    muyeDialog.errorTips("请求失败")
                },
                success: function (res) {
                    muyeDialog.close(index);
                    if (res.code == 0) {
                        muyeDialog.successTips(res.message);
                    } else {
                        muyeDialog.errorTips(res.message);
                    }
                    setTimeout(function () {
                        muyeDialog.closeAll();
                    },3000);
                }
            });
        })
    })
</script>
</body>
</html>