<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${SITE_NAME} - ${SITE_SEO_TITLE} - Powered By silinmuye</title>
    <meta name="keywords" content="${SITE_KEYS}"/>
    <meta name="description" content="${SITE_DESCRIPTION}"/>
    <meta name="author" content="dingdingzhongyuan"/>
    <meta name="baidu-site-verification" content="ezY5ko0raL" />
    <meta name="baidu-site-verification" content="7xUXEI0q4e" />
    <meta name="360-site-verification" content="bad8e48410ecb46ae7a187f3a93eac86" />
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${basePath}/res/common/css/zui.min.css" rel="stylesheet">
    <link href="${basePath}/res/front/css/app.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${basePath}/res/common/js/html5shiv.min.js"></script>
    <script src="${basePath}/res/common/js/respond.min.js"></script>
    <![endif]-->

    <script src="${basePath}/res/common/js/jquery-2.1.1.min.js"></script>
    <script src="${basePath}/res/common/js/zui.min.js"></script>
    <script src="${basePath}/res/plugins/layer/layer.js"></script>
    <script src="${basePath}/res/common/js/jquery.form.js"></script>
    <script src="${basePath}/res/common/js/muye.js"></script>
    <script src="${basePath}/res/common/js/extendPagination.js"></script>
   <#-- 引入飘窗的时候可以接受如下参数-->
 <#--   <script type="text/javascript" src="${basePath}/res/front/js/float.js?id=float&stepx=1&stepy=1&delay=15"></script>-->
    <script type="text/javascript" src="${basePath}/res/front/js/rightBtn.js"></script>

    <style>
        li{ list-style:none}
        #rightButton{ position:fixed; _position:absolute; top:256px; right:0; z-index:999; display:block;}
        #right_ul{ position:relative;}
        #right_qq{  background:url(${basePath}/res/front/images/qq_btn.jpg) no-repeat; width:46px; height:46px; }
        #right_tel{ background:url(${basePath}/res/front/images/tel_btn.jpg) no-repeat; width:46px; height:46px; }
        #top_btn{background: url(${basePath}/res/front/images/top_btn.jpg) no-repeat; width:46px; height:46px; cursor: pointer;}
        #right_tip{  background:#F3F3F3; width:124px; padding-top: 4px; padding-bottom: 4px; position:absolute; right:56px; top:20px; display:none; z-index:999; }
        .flagShow_qq a{display: block; width: 100px; height: 28px; background: #fff; color: #2E2E2E; font:12px/28px 'Microsoft yahei'; margin: 0 auto 10px auto; padding-left: 6px; text-decoration: none; }
        .flagShow_qq a:hover{text-decoration: underline;}
        .flagShow_qq img{vertical-align: middle;}
        .flag_qq{text-indent:0; padding-top:10px;}
        .flag_tel{font: 16px/18px 'Microsoft yahei'; padding-left: 8px; font-style: italic; color: #2E2E2E; text-indent:0; padding-top:20px; padding-bottom:20px; }

    </style>
</head>
<body class="gray-bg">
<#include "/${frontTemplate}/common/header.ftl"/>
<div class="container">
    <div id="banner" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
    <#if (adsModel.data)?size &gt;0>
        <#list adsModel.data as t>
            <#if t_index?if_exists==0>
           <li data-target="#banner" data-slide-to="${t_index}" class="active"></li>
            <#else >
            <li data-target="#banner" data-slide-to="${t_index}"></li>
            </#if>
        </#list>
        <#else >
            <li data-target="#banner" data-slide-to="0" class="active"></li>
    </#if>

        </ol>
        <div class="carousel-inner">

    <#if (adsModel.data)?size &gt;0>
        <#assign count=0>
        <#list adsModel.data as ad>
            <#if count==0>
            <div class="item active">
                <a href="${ad.link}" target="_blank"><img alt="${ad.name}" src="${ad.content}"></a>
                <div class="carousel-caption">
                    <h3>${ad.name}</h3>
                    <p></p>
                </div>
            </div>
            <#else>
                <div class="item">
                    <a href="${ad.link}" target="_blank"><img alt="${ad.name}" src="${ad.content}"></a>
                    <div class="carousel-caption">
                        <h3>${ad.name}</h3>
                        <p></p>
                    </div>
                </div>
            </#if>
            <#assign count=count+1 />
        </#list>
    <#else >
        <div class="item active">
            <img alt="First slide" src="${basePath}/res/front/images/banner1.png" >
            <div class="carousel-caption">
                <h3></h3>
                <p></p>
            </div>
        </div>
    </#if>

        </div>
    </div>

    <div class="main-content m-t-10">
        <div class="row">
            <div class="col-md-12">
                <div class="panel group-topic-list no-border">
                    <div class="panel-heading">
                        推荐产品
                        <span class="pull-right">
                            <a class="btn btn-primary m-t-n4" href="${basePath}/article/list">查看更多</a>
                        </span>
                    </div>
                    <div class="panel-body">
                        <div class="items">
                        <@cms_article_list cid=0 num=16 thumbnail=1; article>
                            <#list articleList as article>
                                <div class="col-md-3">
                                    <div class="item index-article">
                                        <div class="item-content">
                                            <div class="media">
                                                <a href="${basePath}/article/detail/${article.id}">
                                                    <img src="${basePath}${article.thumbnail}" alt="${article.title}" height="150px" width="100%">
                                                </a>
                                            </div>
                                            <h4><a href="${basePath}/article/detail/${article.id}">
                                                <#if article.title?length &gt; 18>
                                                ${article.title?substring(0,18)}...
                                                <#else>
                                                ${article.title}
                                                </#if>
                                            </a></h4>
                                        </div>
                                        <div class="item-footer">
                                            <a href="${basePath}/article/detail/${article.id}" class="text-muted"><i class="icon-comments"></i> ${article.viewCount}</a> &nbsp; <span class="text-muted">${article.createTime?string('yyyy-MM-dd HH:mm')}</span>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </@cms_article_list>
                        </div>
                    </div>
                </div>
            </div>


            <div class="col-md-12">
                <div class="panel group-topic-list no-border">
                    <div class="panel-heading">
                        友情链接
                        <span class="pull-right">
                            <a class="btn btn-primary m-t-n4" href="${basePath}/link">查看更多</a>
                        </span>
                    </div>
                    <div class="panel-body friend-link">
                        <ul>
                        <#list linkModel.data as link>
                            <li><a href="${link.url}" target="_blank">${link.name}</a></li>
                        </#list>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<#--<div style="background: red; width: 200px; height: 100px;" id="float">-->

    <div id="rightButton" style="right: 0px;">
        <ul id="right_ul">
            <li id="right_qq" class="right_ico" show="qq" hide="tel"></li>
            <li id="right_tel" class="right_ico" show="tel" hide="qq"></li>
            <li id="right_tip" style="top: 46px; display: none;">
                <p class="flag_tel" style="display: block;"><a href="tel://${company.strMobile}">${company.strMobile}</a></p>
                <p class="flagShow_qq flag_qq" style="display: none;" id="qq">
                <#--<a href="http://wpa.qq.com/msgrd?v=3&amp;uin=819126279&amp;site=qq&amp;menu=yes" target="_blank" style="cursor: pointer;">
                        <img src="http://wpa.qq.com/pa?p=2:819126279:52" alt="咨询我们" title="咨询我们">
                        <span>咨询我们</span>
                    </a>
                    <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=551730380&amp;site=qq&amp;menu=yes" target="_blank" style="cursor: pointer;">
                        <img src="http://wpa.qq.com/pa?p=2:551730380:52" alt="咨询老师" title="咨询老师">
                        <span>咨询徐老师</span>
                    </a>
                    <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=1327420174&amp;site=qq&amp;menu=yes" target="_blank" style="cursor: pointer;">
                        <img src="http://wpa.qq.com/pa?p=2:1327420174:52" alt="咨询老师" title="咨询老师">
                        <span>咨询王老师</span>
                    </a>
                    <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=786141578&amp;site=qq&amp;menu=yes" target="_blank" style="cursor: pointer;">
                        <img src="http://wpa.qq.com/pa?p=2:786141578:52" alt="咨询老师" title="咨询老师">
                        <span>咨询许老师</span>
                    </a>
                    <a href="http://wpa.qq.com/msgrd?v=3&amp;uin=805509282&amp;site=qq&amp;menu=yes" target="_blank" style="cursor: pointer;">
                        <img src="http://wpa.qq.com/pa?p=2:805509282:52" alt="咨询老师" title="咨询老师">
                        <span>咨询张老师</span>
                    </a>-->
                </p>
            </li>
            <li id="top_btn"></li>
        </ul>
    </div>

</div>
<#include "/${frontTemplate}/common/footer.ftl"/>

<script type="text/javascript">
    $(function () {
        $(".pagination").muye_page("muyePageForm");
    });

    var isTouch=('ontouchstart' in window);
    if(isTouch){
        $(".carousel").on('touchstart', function(e){
            var that=$(this);
            var touch = e.originalEvent.changedTouches[0];
            var startX = touch.pageX;
            var startY = touch.pageY;
            $(document).on('touchmove',function(e){
                touch = e.originalEvent.touches[0] ||e.originalEvent.changedTouches[0];
                var endX=touch.pageX - startX;
                var endY=touch.pageY - startY;
                if(Math.abs(endY)<Math.abs(endX)){
                    if(endX > 10){
                        $(this).off('touchmove');
                        that.carousel('prev');
                    }else if (endX < -10){
                        $(this).off('touchmove');
                        that.carousel('next');
                    }
                    return false;
                }
            });
        });
        $(document).on('touchend',function(){
            $(this).off('touchmove');
        });
    }


    function IsPC() {
        var userAgentInfo = navigator.userAgent;
        var Agents = ["Android", "iPhone",
            "SymbianOS", "Windows Phone",
            "iPad", "iPod"];
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    var flag = IsPC(); //true为PC端，false为手机端

    if(flag){
        $("#qq").append(
       "<a href='http://wpa.qq.com/msgrd?v=3&amp;uin=${company.strQQ}&amp;site=qq&amp;menu=yes' target='_blank' style='cursor: pointer;'>"+
                "<img src='http://wpa.qq.com/pa?p=2:${company.strQQ}:52' alt='咨询我们' title='咨询我们'>"+
                "<span>咨询我们</span></a>"
        );
    }else{
        $("#qq").append(
                "<a href='mqqwpa://im/chat?chat_type=wpa&uin=${company.strQQ}&version=1&src_type=web&web_src=oicqzone.com' target='_blank' style='cursor: pointer;'>"+
                "<img src='http://wpa.qq.com/pa?p=2:${company.strQQ}:52' alt='咨询我们' title='咨询我们'>"+
                "<span>咨询我们</span></a>"
        );
    }








</script>
</body>
</html>