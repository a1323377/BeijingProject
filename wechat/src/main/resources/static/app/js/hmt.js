// JavaScript Document
function hasParam(href,paramName){
    var loc=href.split("?");
    //alert(loc);
    if(loc.length>1){
        loc=loc[1].split("&");
        for(var i=0;i<loc.length;i++){
            if(loc[i].indexOf(paramName)>=0){
                return loc[i].split("=")[1];
            }
        }
        return "";
    }
}
$(function(){
    var code =hasParam(window.location.href,"code");
    $.ajax({
        type:"get",
        url:"http://jusavng.hn3.mofasuidao.cn/wechat/verifylogin.do",
        success:function (data) {
            if(data=="false"){
                if(code!="") {
                    $.ajax({
                        type: "post",
                        url: "http://jusavng.hn3.mofasuidao.cn/wechat/code.do",
                        data: {"code": code},
                        dataType: "json",
                        async: false,
                        success: function (data) {
                            alert("111");
                        },
                        error: function () {
                            alert("222");
                        }
                    });
                }
            }
        }
    })


	//计算内容上下padding
	reContPadding({main:"#main",header:"#header",footer:"#footer"});
	function reContPadding(o){
		var main = o.main || "#main",
			header = o.header || null,
			footer = o.footer || null;
		var cont_pt = $(header).outerHeight(true),
			cont_pb = $(footer).outerHeight(true);
		$(main).css({paddingTop:cont_pt,paddingBottom:cont_pb});
	}
});


//折叠展开列表内容
$(document).ready(function(){
  mui('#slider').on('tap', '.open-btn', function (e) {
	  $(".nav-con").fadeToggle("fast");
	  $(".open-btn span").toggleClass('rotate'); 	
	  if($(".open-btn span").hasClass('rotate')){
		 $("#slider").on("touchmove.ddd",function(e){
			// console.log(e)
			  e.stopPropagation();
		});
	  }else{
		  console.log(1)
		 $("#slider").off("touchmove.ddd");  
	  }
  });
});