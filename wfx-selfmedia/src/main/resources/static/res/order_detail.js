var buyTimes = '0';
var check_code = '';
if (buyTimes > 5) {
    $('#captchaWrap').show();
}
try {
    window.addEventListener('load', function () {
        FastClick.attach(document.body);
    }, false);
} catch (e) {
}
var Item = {
    getItemInfo: function () {
    },
    changeCount: function () {
        $("#item_num").bind("focusout", function () {
            var _this = $(this);
            var val = _this.val();
            if (!val) {
                M._alert("数量不可为空");
                _this.val(1);
                return;
            }
            if (isNaN(val)) {
                M._alert("数量必须为数字");
                _this.val(1);
                return;
            }
            if (Number(val) < 1) {
                M._alert("客官至少买一件嘛");
                _this.val(1);
                return;
            }

            var _v = val;
            var noInt = false;
            if (_v.toString().indexOf(".") != -1) {//有小数点 则先转化一下
                noInt = true;
                _v = Math.floor(val);//优化后的整数
            }
            noInt && M._alert("数量必须为整数");
            _this.val(_v);

            if ($(".sku_cur").length === 0) {
                M._alert("请选择商品类型");
                return;
            }
            var countPrice = $(".sku_cur").attr("data-price") * _v;
            countPrice = Number(countPrice).toFixed(2);


        })
    },
    init: function () {
        Item.changeCount();
        Item.getItemInfo();
        $("#buy_now").bind("click", function () {
            var isRight = true;
            var skuId = $("#item_sku_id").val();//商品ID
            var name = $("#name").val();//收货人
            var tel = $("#tel").val();//联系手机
            var province = $("#province").val();//省
            var city = $("#city").val();//市
            var area = $("#area").val();//区
            var address = $("#address").val();//区
            var rule = /^1[3-8][0-9]\d{4,8}$/;
            var mbcaptcha = $('[name="mbcaptcha"]');
            var captcha = $('[name="captcha"]');
            var captcha_val = captcha.val();
            var mbcaptcha_val = mbcaptcha.val();

            if (skuId == '') {

                showWin.alertWin("请选择商品类型", "success");
                isRight = false;
            } else if (name == '') {

                showWin.alertWin("请填写收货人", "success");
                isRight = false;
            } else if (tel == '') {

                showWin.alertWin("请填写联系手机", "success");
                isRight = false;
            } else if (province == '' || city == '' || area == '') {

                showWin.alertWin("请选择地区", "success");
                isRight = false;
            } else if (address == '') {

                showWin.alertWin("请填写详细地址", "success");
                isRight = false;
            } else if (tel.length != 11 || rule.test(tel) == false) {

                showWin.alertWin("联系手机格式不对", "success");
                isRight = false;
            } else if (mbcaptcha.is(':visible') && mbcaptcha_val.length < 1) {

                showWin.alertWin("请输入手机验证码", "success");
                mbcaptcha.focus();
                isRight = false;
            } else if (captcha.is(':visible') && captcha_val.length < 1) {

                showWin.alertWin("请输入验证码", "success");
                captcha.focus();
                isRight = false;
            }


            if (isRight) {
                if (check_code == 1) {//开启验证
                    //验证手机验证码
                    if (checkMobileCode() == 0) {
                        M._alert('手机验证码不正确!');
                        mbcaptcha.focus();
                        return false;
                    }
                }
                $(this).unbind('click');
                document.getElementById("form_buy").submit();
            }
        });

        $(".js-refresh-check").click(function (event) {
            refreshCheck();
        });
    }
}
Item.init();

//获取校验码
function refreshCheck() {
    var url = '/fxmall/index/captcha';
    $('.check-code').attr('src', url + '?t=' + new Date().getTime());
    $('.captcha').val('').focus();
}

//获取手机验证码
function getMobileCode() {
    var mobile = $("#tel").val();
    if (mobile == '') {
        M._alert("请填写手机号码");
        return false;
    }
    var action = '/fxmall/mobile/vcode';
    $.ajax({
        url: action,
        type: 'post',
        data: "mobile=" + mobile,
        dataType: 'text',
        success: function (response) {
            var suc = response.split("#")[0];
            var msg = response.split("#")[1];
            if (suc == '1') {
                M._alert(msg);
                countDown(60);
            } else {
                M._alert(msg);
            }
        },
        error: function () {
            M._alert("获取验证码失败!");
        }
    });
}
//验证手机验证码
function checkMobileCode() {
    var vcode = $("#mbcaptcha").val();
    if (vcode == '') {
        alert("请填写手机手机验证码!");
        return false;
    }
    var action = '/fxmall/mobile/check';
    var param = "vcode=" + vcode;
    return commonLoad(action, param, "post");
}
function countDown(secs) {
    $('[name="ckbtn"]').val(secs + "秒后重新获取")
    $("#ckbtn").attr("disabled", true);
    if (--secs > 0) {
        setTimeout("countDown(" + secs + ")", 1000);
    } else {
        $("#ckbtn").removeAttr("disabled");
    }
}
function commonLoad(url, param, method) {
    var obj;
    var value;
    if (window.ActiveXObject) {
        obj = new ActiveXObject('Microsoft.XMLHTTP');
    } else if (window.XMLHttpRequest) {
        obj = new XMLHttpRequest();
    }
    obj.open(method, url, false);
    obj.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    obj.send(param);
    var result = obj.responseText
    return result;
}
function clearrvl() {
    document.form_buy.reset();
}
function dosubmit() {
    //获取表单提交按钮
    var btnSubmit = document.getElementById("buy_now");
    //将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
    btnSubmit.disabled = "disabled";
    //返回true让表单可以正常提交
    return true;
}
function changeAtt(t) {
    t.lastChild.checked = 'checked';
    for (var i = 0; i < t.parentNode.childNodes.length; i++) {
        if (t.parentNode.childNodes[i].className == 'cattsel') {
            t.parentNode.childNodes[i].className = '';
        }
    }
    t.className = "cattsel";
    changePrice();
}

/**
 * 点选可选属性或改变数量时修改商品价格的函数
 */
function changePrice() {

    var attr = getSelectedAttributes(document.forms['form_buy']);
    var attr_id = '';

    for (var i = 0; i < attr.length; i++) {
        attr_id += attr[i] + ',';
    }
    attr_id = attr_id.substring(0, attr_id.length - 1);
    //alert(attr_id);
    var pay_type = $('input[name="pay_type"]:checked').val();
    ;
    //alert(pay_type);

    $.ajax({
        url: "http://115.29.207.161:8080//getGoodPrice",// 跳转到 action
        data: {
            "goods_id": 'pb1n3rya',
            "attr_id": attr_id,
            "pay_type": pay_type
        },
        type: 'post',
        cache: false,
        dataType: "text",
        success: function (result) {
            $data = eval("(" + result + ")");
            // alert($data.jg);
            $("#item_price").html("￥" + $data.jg);
            $("#attr_id").val($data.attr_id);
        },
        error: function () {

            // alert("异常！");
        }
    });

}

function getSelectedAttributes(formBuy) {
    var spec_arr = new Array();
    var j = 0;

    for (i = 0; i < formBuy.elements.length; i++) {
        var prefix = formBuy.elements[i].name.substr(0, 5);

        if (prefix == 'spec_' && (
            ((formBuy.elements[i].type == 'radio' || formBuy.elements[i].type == 'checkbox') && formBuy.elements[i].checked) ||
            formBuy.elements[i].tagName == 'SELECT')) {
            spec_arr[j] = formBuy.elements[i].value;
            j++;
        }
    }

    return spec_arr;
}

changePrice();
var jishi = 0;

function setjishi() {
    jishi = jishi + 1;

    $("#miaoshu").val(jishi);
}
setInterval('setjishi()', 1000);