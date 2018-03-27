<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><#if articleCate??>${articleCate.name}<#else>联系我们</#if> - ${SITE_NAME} - Powered By silinmuye</title>
    <meta name="keywords" content="${SITE_KEYS}"/>
    <meta name="description" content="${SITE_DESCRIPTION}"/>
    <meta name="author" content="MUYE"/>
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
<style>

    .mapdv {
        width:400px;
        height:300px;
        border:1px solid red;
    }

</style>
</head>
<body class="gray-bg">
<#include "/${frontTemplate}/common/header.ftl"/>
<div class="container">
    <div class="main-content">
        <div class="row">
            <div class="col-md-8">
                <p style="font-size: 12pt;font-weight: bold">${company.strTitle}</p>
                <table style="margin-top:5px;" cellspacing="0" cellpadding="0">
                    <tr>
                        <td  colspan="2">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2">
						<p style="font-size: 12pt">
                            &nbsp;&nbsp;&nbsp;&nbsp;${company.strContent}
                      </p>
                        </td>
                    </tr>
                    <tr>
                        <td style="align:left">${company.strManger}：&nbsp;&nbsp;${company.strMangerName}</td><td>&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="align:left">联系电话：<a href="tel://${company.strMobile}">${company.strMobile}</a></td><td >&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="align:left">邮箱：${company.strEmail}</td><td >&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="align:left">QQ：${company.strQQ}</td><td >&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="align:left">微信：${company.strWechat}</td><td >&nbsp;</td>
                    </tr>
                    <tr>
                        <td style="align:left">地址：${company.strAddress}</td><td >&nbsp;</td>
                    </tr>

                </table>
            </div>
            <div class="col-md-4 float-left" id="leftDiv">
                <div class="panel">
                    <span>官方微信二维码</span>
                   <img width="200px" height="200px"  src="${company.strErWerUrl}">
                </div>
                <div id="qq">

                  <#--  <a class="btn btn-success"
                       href="http://wpa.qq.com/msgrd?v=3&uin=${company.strQQ}&site=qq&menu=yes" target="_blank">
                        <i class="fa fa-qq"> </i> QQ联系我
                    </a>
                    <a class="btn btn-success"
                       href=" mqqwpa://im/chat?chat_type=wpa&uin=${company.strQQ}&version=1&src_type=web&web_src=oicqzone.com" target="_blank">
                        <i class="fa fa-qq"> </i> 手机QQ联系我
                    </a>-->


                </div>
                <div id="wallet20Map" class="mapdv"></div><br>
                <a href="bdapp://map/marker?location=${company.strLatitude},${company.strLongitude}&title=Marker&content=makeamarker&traffic=on">用手机百度地图导航</a><br>
               <#-- <a href="androidamap://navi?sourceApplication=appname&amp;poiname=fangheng&amp;lat=${company.strLatitude}&amp;lon=${company.strLongitude}&amp;dev=1&amp;style=2">用手机高德导航</a>-->
            <#if loginUser?? && loginUser.isAdmin &gt; 0><#--如果是管理员那么地图改变是显示经纬度-->
                <input id="consoledv" name="consoledv" value="" onkeyup="value=value.replace(/[^0-9\.\,]/g,'')"  class="brk-input"  type="text"/>
            </#if>




            </div>
        </div>
    </div>
</div>
<#include "/${frontTemplate}/common/footer.ftl"/>
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=AzH6TMPUpha8Ig2yEzw6Shb2&callback=initialize"></script>
<script type="text/javascript">
    var strLongitude = ${company.strLongitude};
    var strLatitude = ${company.strLatitude};

    function initialize() {
        var bkmap = new BMap.Map("wallet20Map");
        var bkpnt = new BMap.Point(strLongitude,strLatitude);
        bkmap.centerAndZoom(bkpnt, 11);
        //创建标注
        var bkmarker = new BMap.Marker(bkpnt);
        bkmarker.addEventListener("mouseup", function(e){
            var sum = e.point.lng + "," + e.point.lat;
            $("#consoledv").val(sum);
        });
        bkmap.addControl(new BMap.ScaleControl({anchor: BMAP_ANCHOR_TOP_LEFT}));
        bkmap.addControl(new BMap.NavigationControl());
        //这个会在右上角展示地图/卫星/三维
        //bkmap.addControl(new BMap.MapTypeControl());

        //添加标记并允许拖动
        bkmap.addOverlay(bkmarker);
        bkmarker.enableDragging();

        bkmap.setCurrentCity("郑州");
    }
    clientType();
    function clientType() {
        var userAgentInfo = navigator.userAgent;
        var Agents = [ "iPhone", "iPad", "iPod"];
        var Agents2 = "Android";
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                $("#leftDiv").append(
                        "<a href='iosamap://navi?sourceApplication=appname&amp;poiname=fangheng&amp;lat=${company.strLatitude}&amp;lon=${company.strLongitude}&amp;dev=1&amp;style=2'>用手机高德导航</a><br>"
                );
                break;
            }else if(userAgentInfo.indexOf(Agents2) > 0){
                $("#leftDiv").append(
                "<a href='androidamap://navi?sourceApplication=appname&amp;poiname=fangheng&amp;lat=${company.strLatitude}&amp;lon=${company.strLongitude}&amp;dev=1&amp;style=2'>用手机高德导航</a>"
                );
                break;
            }
        }
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
        "<a class='btn btn-success' href='http://wpa.qq.com/msgrd?v=3&uin=${company.strQQ}&site=qq&menu=yes' target='_blank'> <i class='fa fa-qq'> </i> QQ联系我</a>"
        );
    }else{
        $("#qq").append(
        "<a class='btn btn-success'  href=' mqqwpa://im/chat?chat_type=wpa&uin=${company.strQQ}&version=1&src_type=web&web_src=oicqzone.com' target='_blank'> <i class='fa fa-qq'> </i>QQ联系我</a> ");
    }



</script>
</body>
</html>