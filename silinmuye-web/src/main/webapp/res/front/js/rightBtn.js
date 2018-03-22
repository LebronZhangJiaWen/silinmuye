/**
 * Created by zhangjiawen on 2018/3/21.
 */
$(document).ready(function(e) {
    $("#rightButton").css("right", "0px");

    var button_toggle = true;
    $(".right_ico").on("mouseover", function () {
        var tip_top;
        var show = $(this).attr('show');
        var hide = $(this).attr('hide');
        tip_top = show == 'tel' ? 46 : 0;
        button_toggle = false;
        $("#right_tip").css("top", tip_top).show().find(".flag_" + show).show();
        $(".flag_" + hide).hide();

    }).on("mouseout", function () {
        button_toggle = true;
        hideRightTip();
    });


    $("#right_tip").on("mouseover", function () {
        button_toggle = false;
        $(this).show();
    }).on("mouseout", function () {
        button_toggle = true;
        hideRightTip();
    });

    function hideRightTip() {
        setTimeout(function () {
            if (button_toggle) $("#right_tip").hide();
        }, 500);
    }

    $("#top_btn").click(function () {
        if (scroll == "off") return;
        $("html,body").animate({scrollTop: 0}, 600);
    });

});