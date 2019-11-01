    $(function () {
        var errorTimes= $.cookie('loginErrorTimes') || 0;
        if(errorTimes>3){
            refreshCheck();
            $('#captcha').show();
        }
        var old_user_name=$.cookie('login_name');
        if(old_user_name!=undefined){
            $('#username').val(old_user_name);
        }

        var form = $('#form');
        var submitBtn = $('#submit');

        form.keypress(function(e){
            if(e.keyCode==13){
                submitBtn.click();
            }
        })

        submitBtn.click(function () {
            var user_name=$('[name="username"]');
            var user_name_val=user_name.val();
            var password=$('[name="password"]');
            var password_val=password.val();
            var captcha=$('[name="captcha"]');
            var captcha_val=captcha.val();
            if(user_name_val.length<1){
                toastr.error('请输入用户名');
                user_name.focus();
                return false
            }
            if(password_val.length<1){
                toastr.error('请输入密码');
                password.focus();
                return false
            }
            if(captcha.is(':visible') &&captcha_val.length<1){
                toastr.error('请输入验证码');
                captcha.focus();
                return false
            }

            if(filterSqlStr(user_name_val)){
                toastr.error("用户名不能有特殊字符【"+sql_str()+"】");
                captcha.focus();
                return false
            }

            if(filterSqlStr(password_val)){
                toastr.error("密码不能有特殊字符【"+sql_str()+"】");
                captcha.focus();
                return false
            }

            if(captcha.is(':visible') && filterSqlStr(captcha_val)){
                toastr.error("验证码不能有特殊字符【"+sql_str()+"】");
                captcha.focus();
                return false
            }

            if (submitBtn.hasClass('js-loading')) {
                return false;
            }

            var is_remember=$('[name="remember"]').is(':checked');
            if(is_remember){
                $.cookie('login_name', user_name_val, { expires: 7, path: '/' });
            }

            var action;
            if($("#user_type").val()==0){
                action = "user/login";
            }else{
                action = "cust/login";
            }
            var data = form.serialize();
            var loading = App.showLoading(submitBtn);

            console.log(data);
            console.log(loading);

            $.ajax({
                url: action,
                type: 'post',
                data: {data:data},
                dataType: 'text',
                success: function (response) {
                    var suc = response.split("#")[0];
                    var msg = response.split("#")[1];
                    loading.revert();
                    if (suc == 'true') {
                        submitBtn.unbind('click');
                        $.cookie('loginErrorTimes',0);
                        toastr.success('', '登录成功');
                        if($("#user_type").val()==0){
                            window.location.href = "/user/register";
                        }else{
                            window.location.href = "/user/login";
                        }
                    } else {
                        errorTimes++;
                        if(errorTimes>3){
                            refreshCheck();
                            $('#captcha').show();
                        }
                        $.cookie('loginErrorTimes',errorTimes);
                        toastr.error(msg, '登录失败');
                        refreshCheck();
                    }
                },
                error: function () {
                    loading.revert();
                }
            });
        });

        $(".js-refresh-check").click(function (event) {
            refreshCheck();
        });
    });


//过滤一些敏感字符函数
function filterSqlStr(value){
    var sqlStr=sql_str().split(',');
    var flag=false;
    for(var i=0;i<sqlStr.length;i++){
        if(value.toLowerCase().indexOf(sqlStr[i])!=-1){
            flag=true;
            break;
        }
    }
    return flag;
}


function sql_str(){
    var str="*,',join,>,<";
    return str;
}

function clickRadio(id){
    $("#user_type").val(id);
}

//获取校验码
function refreshCheck() {
    var url = '/index/captcha';
    $('.check-code').attr('src', url + '?t=' + new Date().getTime());
    $('.captcha').val('').focus();
}

// 判断当前访问者的客户端设备类型、操作系统及浏览器类型
function jupmBrowserType() {
    var browser = {
        versions: function () {
            var u = navigator.userAgent, app = navigator.appVersion;
            return { // 客户端浏览器版本信息
                trident: u.indexOf('Trident') > -1, // IE内核
                webKit: u.indexOf('AppleWebKit') > -1, // 苹果、谷歌内核
                mobile: !!u.match(/AppleWebKit.*Mobile.*/), // 是否为移动终端
                android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, // android终端或者uc浏览器
                iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1 // 是否为iPhone或者QQHD浏览器
            };
        } ()
    }
    // 是否为移动终端
    if (!browser.versions.mobile) {
        // 是否为IE内核
        if (browser.versions.trident) {
            return 4;
        } else if (browser.versions.webKit) { // 是否为苹果、谷歌内核
            return 1;
        } else {
            return 0;
        }
    } else {
        // 是否为android终端
        if (browser.versions.android) {
            return 2;
        } else if (browser.versions.iPhone) { //是否为iPhone终端
            return 3;
        } else {
            return 0;
        }
    }
}




        jQuery(document).ready(function() {
            App.init();
            $("#ismobile").val(jupmBrowserType());
        });


        (function(config){
            config['extendDrag'] = true; // 注意，此配置参数只能在这里使用全局配置，在调用窗口的传参数使用无效
            config['lock'] = true;
            config['fixed'] = true;
            config['okVal'] = '确定';
            config['cancelVal'] = '取消';
        })($.dialog.setting);

    // 如果只设置一个或少量全局配置也可这样：
    $.dialog.setting.extendDrag = true;
    $.dialog({
        title: '会员公告',
        content: '<font style="font-size:16px;color:#cc0033">全体微力汇会员：<br/>&nbsp;&nbsp;&nbsp;您们好，由于最近两天系统更新和升级，导致帐号出现登录问题，<br/>请及时联系首页上方客服咨询，望大家理解!</font>',
        cancelVal: '明白了',
        cancel: true
    });


        //自动弹出公告
        //     var str = 12;
        //     if( !str || str != 13 ){
        //      var nstitle = '网站公告';
        //      var nstext = '网站公告22a';
        //      if( nstitle!='' && nstext!=''){
        //        var modal=Win.open({
        //              title:nstitle,
        //              content:nstext,
        //              width:710,
        //              height:340
        //          });
        //
        //
        //      }
        //
        //     }

/*
<!--<div id="topcontrol" style="position: fixed; bottom: 110px; right: 10px; opacity: 0; cursor: pointer; " title="返回顶部"><div class="back-to-top"></div></div>-->

<!-- cnzz 统计开始
<div style='display:none'>
<script type="text/javascript">
var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cspan id='cnzz_stat_icon_307679'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s19.cnzz.com/stat.php%3Fid%3D307679' type='text/javascript'%3E%3C/script%3E"));
</script>
</div>
 cnzz 统计结束-->
<!-- footer over-->
 */