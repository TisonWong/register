var deviceWidth;
setHtmlFontSize();

/* 监控屏幕大小， 发生变化时调用setHtmlFontSize()对页面字体大小调整 */
if(window.addEventListener){
    window.addEventListener('resize', function(){
        setHtmlFontSize();
    },false);
}

/**
 * 浏览器可视窗口发生变化时触发
 */
function  setHtmlFontSize() {
    // console.log(deviceWidth)
    // 1920 是设计稿的宽度， 当大于1920时采用 1920宽度， 比例也是除以13.66
    deviceWidth = document.documentElement.clientWidth > 1920 ? 1920: document.documentElement.clientWidth;
    document.getElementsByTagName("html")[0].style.cssText = "font-size:"+deviceWidth / 80 +"px !important";
}

