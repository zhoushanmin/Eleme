$(function () {
    $("#ul01>li").first().css({borderBottom:"2px solid #20a2f6"}).children(".p1").addClass("style1_p")
        .parent().children(".span1").addClass("style1_span").parent().siblings()
        .css({borderBottom:"1px solid #8d9099"}).children(".p1").addClass("style3_p")
        .parent().children(".span1").addClass("style3_span");

    $(".image").click(function () {
        var id = $(this).attr("id");
        var num = id.substring(id.length-1);
        $("#file"+num).click();
    });

    $(".file").change(function () {
        var filePath = $(this).val();
        var fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
        // 检查是否是图片
        if( !fileFormat.match(/.png|.jpg|.jpeg|.gif/) ) {
            alert('上传错误,文件格式必须为：png/jpg/jpeg/gif');
            return;
        }
        var src = window.URL.createObjectURL(this.files[0]);
        var id = $(this).attr("id");
        var num = id.substring(id.length-1);
        $("#image"+num).attr("src",src);
    });
    
    $("#input2").click(function () {
        $(".bu").css({display:"block"});
        var top = $(document).scrollTop();
        $(document).on('scroll.unable',function (e) {
            $(document).scrollTop(top);
        });
    });
    $("#quxiao").click(function () {
        $(".bu").css({display:"none"});
         $(document).unbind("scroll.unable");
    });

    $("#btn1").on("click",function () {
    	if($("#shop_name").val() === ""){
    		alert("请输入店铺牌匾名！");
    		$("#shop_name").focus();
    		return;
    	}
    	if($("#input2").val() === "省 - 市 - 区/县"){
    		alert("请选择所在地区！");
    		return;
    	}
    	if($("#detailed_address").val() === ""){
    		alert("请输入门店详细地址！");
    		$("#detailed_address").focus();
    		return;
    	}
    	if($("#business_category").val() === ""){
    		alert("请输入营业类目！");
    		$("#business_category").focus();
    		return;
    	}
    	if($("#file1").val() === ""){
    		alert("请上传门脸照图片！");
    		return;
    	}
    	if($("#file2").val() === ""){
    		alert("请上传店内照图片！");
    		return;
    	}
    	if($("#file3").val() === ""){
    		alert("请上传门店LOGO！");
    		return;
    	}
    	if($("#take_out_phone").val() === ""){
    		alert("请输入外卖电话！");
    		$("#take_out_phone").focus();
    		return;
    	}
    	if($("#contact_name").val() === ""){
    		alert("请输入联系人姓名！");
    		$("#contact_name").focus();
    		return;
    	}
        $(".mendianxinxi").css({display:"none"});
        $(".zizhizhengzhao").css({display:"block"});
        $("#ul01>li").first().css({borderBottom:"1px solid #8d9099"}).children(".p1").addClass("style2_p")
        .parent().children(".span1").addClass("style2_span");
        $("#ul01>li:nth-child(2)").css({borderBottom:"2px solid #20a2f6"}).children(".p1").removeClass("style3_p").addClass("style1_p")
        .parent().children(".span1").removeClass("style3_span").addClass("style1_span");
    });

    $("#btn2").on("click",function () {
        $(".mendianxinxi").css({display:"block"});
        $(".zizhizhengzhao").css({display:"none"});
        $("#ul01>li").first().css({borderBottom:"2px solid #20a2f6"}).children(".p1").removeClass("style2_p").addClass("style1_p")
        .parent().children(".span1").removeClass("style2_span").addClass("style1_span").parent().siblings()
        .css({borderBottom:"1px solid #8d9099"}).children(".p1").addClass("style3_p")
        .parent().children(".span1").addClass("style3_span");
    });

    $("#btn3").on("click",function () {
    	
    	if($("#main_document_type").val() === ""){
    		alert("请输入主体资质证件类型！");
    		$("#main_document_type").focus();
    		return;
    	}
    	if($("#file4").val() === ""){
    		alert("请上传主体资质证件照片！");
    		return;
    	}
    	if($("#industry_document_type").val() === ""){
    		alert("请输入行业资质证件类型！");
    		$("#industry_document_type").focus();
    		return;
    	}
    	if($("#file5").val() === ""){
    		alert("请上传行业资质证件照片！");
    		return;
    	}
        $(".zizhizhengzhao").css({display:"none"});
        $(".kaidianren").css({display:"block"});
        $("#ul01>li").last().css({borderBottom:"2px solid #20a2f6"}).children(".p1").addClass("style1_p")
        .parent().children(".span1").addClass("style1_span").parent().siblings()
        .css({borderBottom:"1px solid #8d9099"}).children(".p1").addClass("style2_p")
        .parent().children(".span1").addClass("style2_span");
    });

    $("#btn4").on("click",function () {
        $(".zizhizhengzhao").css({display:"block"});
        $(".kaidianren").css({display:"none"});
        $("#ul01>li").first().css({borderBottom:"1px solid #8d9099"}).children(".p1").addClass("style2_p")
        .parent().children(".span1").addClass("style2_span");
        $("#ul01>li:nth-child(2)").css({borderBottom:"2px solid #20a2f6"}).children(".p1").removeClass("style2_p").addClass("style1_p")
        .parent().children(".span1").removeClass("style2_span").addClass("style1_span").parent()
            .next().css({borderBottom:"1px solid #8d9099"});
    });
    
    $("#sure").on("click",function () {
        var province = $("#province option:selected").text();
        var city = $("#city option:selected").text();
        var county = $("#county option:selected").text();
        if(province === "-请选择-"){
            alert("请选择省份！");
            return;
        }
        if(city === "-请选择-"){
            alert("请选择城市！");
            return;
        }
        if(county === "-请选择-"){
            alert("请选择区/县！");
            return;
        }
        $("#input2").val(province + "-" + city + "-" + county);
        $(".bu").css({display:"none"});
        $(document).unbind("scroll.unable");
    });
});

function toVaild() {
	if($("#user_name").val() === ""){
		alert("请输入姓名！");
		$("#user_name").focus();
		return false;
	}
	if($("#user_nation").val() === ""){
		alert("请输入民族！");
		$("#user_nation").focus();
		return false;
	}
	if($("#user_birthday").val() === ""){
		alert("请输入出生年月！");
		$("#user_birthday").focus();
		return false;
	}
	var reg = /^\d{4}-\d{2}$/;
	if(!reg.test($("#user_birthday").val())){
		alert("请输入正确格式的出生年月！");
		return false;
	}
	if($("#user_home_address").val() === ""){
		alert("请输入家庭住址！");
		$("#user_home_address").focus();
		return false;
	}
	if($("#file6").val() === ""){
		alert("请上传身份证件正面照片！");
		return false;
	}
	if($("#file7").val() === ""){
		alert("请上传身份证件反面照片！");
		return false;
	}
	if($("#file8").val() === ""){
		alert("请上传手持身份证正面照片！");
		return false;
	}
	return true;
}