var baseUrl = '';
function submitData(){
    var gid = "";
    var url = "good/save                                                                            ";
    //var spc_id = getRadioValue('scopy_id');
    var spc_ids = getCheckBoxValue('scopy_id');
    var zon_ids = getCheckBoxValue('zcopy_id');
    var copy_ids = getCheckBoxValue("gcopy");
    if(isNull($("#good_name").val())){
        $.dialog.alert("对不起！商品名称不能为空！");
        return false;
    }

    if(isNull($("#type_id").val())){
        $.dialog.alert("对不起！请选择商户分类！");
        return false;
    }

    if(isNull($("#promote_desc").val())){
        $.dialog.alert("对不起！推广说明不能为空！");
        return false;
    }

    if(isNull(copy_ids)){
        $.dialog.alert("对不起！请选择微信文案！");
        return false;
    }

    /*if(isNull(spc_id)){
      $.dialog.alert("对不起！请选择站内文案！",null,false);
      return false;
    }*/

    if(isNull($("#order_no").val())){
        $.dialog.alert("对不起！排序编号不能为空！");
        return false;
    }

    //处理sku
    var tab_rows = document.getElementById('tcbg').rows.length
    if(tab_rows==1){
        $.dialog.alert("对不起！请先设置商品套餐！");
        return false;
    }

    var ms="";
    var cb="";
    var jg="";
    var fc="";
    var kffc="";
    for(var i=0;i<tab_rows-1;i++){

        if(!isNull($("#sku"+(i+1)).val())){
            ms += $("#sku"+(i+1)).val()+"|";
        }

        if(!isNull($("#cb"+(i+1)).val())){
            cb += $("#cb"+(i+1)).val()+"|";
        }

        if(!isNull($("#jg"+(i+1)).val())){
            jg += $("#jg"+(i+1)).val()+"|";
        }

        if(!isNull($("#fc"+(i+1)).val())){
            fc += $("#fc"+(i+1)).val()+"|";
        }

        if(!isNull($("#kffc"+(i+1)).val())){
            kffc += $("#kffc"+(i+1)).val()+"|";
        }

    }

    var sku_str="";
    for(var i=0;i<tab_rows-1;i++){

        if(!isNull($("#sku_id_"+(i+1)).val())){
            sku_str += $("#sku_id_"+(i+1)).val()+"|";
        }else{
            sku_str += "newid|";
        }

        if(!isNull($("#sku"+(i+1)).val())){
            sku_str += $("#sku"+(i+1)).val()+"|";
        }

        if(!isNull($("#cb"+(i+1)).val())){
            sku_str += $("#cb"+(i+1)).val()+"|";
        }

        if(!isNull($("#jg"+(i+1)).val())){
            sku_str += $("#jg"+(i+1)).val()+"|";
        }

        if(!isNull($("#fc"+(i+1)).val())){
            sku_str += $("#fc"+(i+1)).val()+"|";
        }

        if(!isNull($("#kffc"+(i+1)).val())){
            sku_str += $("#kffc"+(i+1)).val()+"|";
        }

        sku_str +="$";
    }

    //验证商品是否已经存在
    if(checkGoodName($("#good_name").val(),gid)=='true'){
        $.dialog.alert("对不起！您已经录入同名的商品了！");
        return false;
    }

    $.dialog.confirm('你确定要提交数据吗？', function(){
        $.dialog.tips('数据保存中...',600,'loading.gif');
        var sform = document.copy_form;
        if(sform){
            sform.action = baseUrl+"/"+url;
            $('#sku_str').val(sku_str);
            $('#sku_title').val(ms);
            $('#sku_cost').val(cb);
            $('#sku_price').val(jg);
            $('#sku_pmoney').val(fc);
            $('#service_money').val(kffc);
            $('#copy_id').val(copy_ids);
            $('#spc_id').val(spc_ids);
            $('#zon_id').val(zon_ids);

            setTimeout(function(){
                sform.submit();
            },500);
        }
    });

}

//验证商户是否在使用
function checkGoodName(name,gid){
    var param = "good_id="+gid+"&good_name="+name+"&now="+new Date().getTime();
    return commonLoad("cust/goods/check",param,"post");
}

var tags = "";
if(tags!=""){
    var com_obj = document.getElementsByName("tags");
    for(var j=0;j<com_obj.length;j++){
        if(tags.indexOf(com_obj[j].value)!=-1){
            com_obj[j].checked = true;
        }else{
            com_obj[j].checked = false;

        }
    }
}

var copys = "";
if(copys!=""){
    var com_obj = document.getElementsByName("gcopy");
    for(var j=0;j<com_obj.length;j++){
        if(copys.indexOf(com_obj[j].value)!=-1){
            com_obj[j].checked = true;
        }else{
            com_obj[j].checked = false;
        }
    }
}

var spc_ids = "";
if(spc_ids!=""){
    var com_obj = document.getElementsByName("scopy_id");
    for(var j=0;j<com_obj.length;j++){
        if(spc_ids.indexOf(com_obj[j].value)!=-1){
            com_obj[j].checked = true;
        }else{
            com_obj[j].checked = false;
        }
    }
}

var zon_ids = "";
if(zon_ids!=""){
    var com_obj = document.getElementsByName("zcopy_id");
    for(var j=0;j<com_obj.length;j++){
        if(zon_ids.indexOf(com_obj[j].value)!=-1){
            com_obj[j].checked = true;
        }else{
            com_obj[j].checked = false;
        }
    }
}
