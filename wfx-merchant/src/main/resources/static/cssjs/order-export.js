function goSubmit(){
    var good_name = $("#good_name").val();
    var buyer_name = $("#buyer_name").val();
    var buyer_phone = $("#buyer_phone").val();
    var account = $("#account").val();
    var start_date = $("#start_date").val();
    var end_date = $("#end_date").val();
    var order_id = $("#order_id").val();

    document.formSelect.action="cust/order/list?good_name=" + good_name
        +"&buyer_phone=" + buyer_phone
        +"&order_id=" + order_id
        +"&start_date=" + start_date
        +"&end_date=" + end_date
        +"&state_id="
        +"&account=" + account
        +"&buyer_name=" + buyer_name;
    document.formSelect.submit();
}

function seeOrder(id){
    window.location.href = "/order/process?order_id="+id;
}

function exportOrder(){
    window.location.href = "/cust/export/2";
}

function exportSelOrder(){
    var arr = getAllCheckVal("tbck");
    if(arr == null || arr.length==0){
        $.dialog.alert("请先选择要导出的订单！");
        return;
    }
    var oid=Arr2String(arr);
    window.location.href = "/cust/export/?tempid=1&order_id="+oid
}

function exportOrderAll(){
    window.location.href = "/cust/export/?tempid=1";
}

function exportAllOrder(){
    var url = "/cust/export/1";
    var msg = "您确定要导出选择的订单吗?"
    var arr = getAllCheckVal("tbck");
    if(arr == null || arr.length==0){
        msg = "<font color=red>你确定要导出全部已下单的订单吗？</font>"
    }else{
        url = url+"?order_id="+Arr2String(arr);
    }
    $.dialog.confirm(msg, function(){
        window.location.href = url;
    });
}

function signOrder(){
    window.location.href = "/cust/order/bsign";
}

function importOrder(){
    window.location.href =  "/cust/order/import";
}

function exportCSelOrder(){
    var arr = getAllCheckVal("tbck");
    if(arr == null || arr.length==0){
        $.dialog.alert("请选择要导出COD的订单！");
        return;
    }
    var oid=Arr2String(arr);
    window.location.href = "/cust/export/2?tempid=2&order_id="+oid

}

function editOrder(id,sid){
    /*if(sid!=1){
       $.dialog.alert("对不起，进入流程的订单不能修改！");
       return;
    }*/
    window.location.href = "/cust/order/modify?order_id="+id;
}

//批量审核
function batchCheck(){
    var arr = getAllCheckVal("tbck");
    if(arr == null || arr.length==0){
        $.dialog.alert("请先选择要操作的数据！");
        return;
    }else{
        var ids = Arr2String(arr);
        $.dialog({
            title:'批量审核',
            id: 'batch_check',
            width:380,
            height:170,
            content: "url:/cust/order/bchange?order_id="+ids,
            lock:false
        });
    }

}

//批量删除订单
function batchDel(){
    var arr = getAllCheckVal("tbck");
    if(arr == null || arr.length==0){
        $.dialog.alert("请先选择要操作的数据！");
        return;
    }

    var ids = Arr2String(arr);
    delOrder(ids,'1');
}

function delOrder(id,sid){
    if(id == null || id==''){
        $.dialog.alert("请先选择要删除的数据！");
        return;
    }
    if(sid!=1 && sid!=3){
        $.dialog.alert("对不起，订单进入审核流程不能删除！");
        return;
    }


    $.dialog.confirm('<font color=red>你确定要删除订单数据吗？</font>', function(){
        $.dialog.tips('数据处理中...',600,'loading.gif');
        var param = "order_id="+id+"&now="+new Date().getTime();
        jQuery.ajax({
            type: "post",
            cache : false,
            url: "/cust/order/delete",
            data: param,
            success: function(result){
                if(result=='true'){
                    $.dialog.alert("恭喜你，删除订单信息成功！");
                    setTimeout('reloadPage();',500);
                }
                if(result=='false'){
                    $.dialog.alert("对不起，删除订单信息失败！");
                }
            }
        });

    });
}
