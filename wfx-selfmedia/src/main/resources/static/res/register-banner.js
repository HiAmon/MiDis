$(function () {
    var bannerNum=$('#banner .banner-wrap > div').length;//有几个 banner
    var bannerIntervalTime=5000;//IntervalTime
    $('#banner').addClass('show1');
    var bannerInterval,bannerTimeout;
    bannerTimeout=setTimeout(function () {
        bannerInterval=setInterval(showNextBanner,bannerIntervalTime)
    },2000);

    $('#banner .arrow-left,#banner .arrow-right').click(function () {
        var type=$(this).attr('data-type');
        var now=$('#banner .banner-nav .active').attr('data-index');
        var next;//下次的banner 顺序
        if(type=='left'){
            next=parseInt(now,10)-1;
        }else{
            next=parseInt(now,10)+1;
        }
        if(next<1){
            next=bannerNum;
        }
        if(next>bannerNum){
            next=1;
        }
        clearInterval(bannerInterval);
        clearTimeout(bannerTimeout);
        showBanner(next);
    });
    $('#banner .banner-nav li').click(function () {
        var index=$(this).attr('data-index');
        showBanner(index);
    });

    $('#banner').hover(function () {
        clearInterval(bannerInterval);
        clearTimeout(bannerTimeout);
        $('.arrow-left,.arrow-right').show();
    }, function () {
        $('.arrow-left,.arrow-right').hide();
        bannerTimeout=setTimeout(function () {
            bannerInterval=setInterval(showNextBanner,bannerIntervalTime)
        },0);
    });

    function showNextBanner(){
        var now=$('#banner .banner-nav .active').attr('data-index');
        var next=parseInt(now,10)+1;
        if(next<1){
            next=bannerNum;
        }
        if(next>bannerNum){
            next=1;
        }
        showBanner(next);
    }

    function showBanner(index){
        $('#banner .banner-nav .active').removeClass('active');
        $('#banner .banner-nav li').eq(index-1).addClass('active');
        $('#banner').attr('class','index-banner').addClass('show'+index);
    }
});