$(function(){
	
	$("#input_number").focus(function () {
        $(".phoneNumber").css({"borderColor":"#47a9ff"});
    });
    $("#input_number").blur(function () {
        $(".phoneNumber").css({"borderColor":"#dedfe0"});
    });
    $("#verifyCode").focus(function () {
        $(".code").css({"borderColor":"#47a9ff"});
    });
    $("#verifyCode").blur(function () {
        $(".code").css({"borderColor":"#dedfe0"});
    });
    $("#input_number").keyup(function () {
            var number = $(this).val();
            var code = $("#verifyCode").val();
            var check = $("#check").prop("checked");
            var len = number.length;
            if(len === 11){
                $("#sendVerifyCode").css({color:"#47a9ff"});
                $(".cloth1").css({"display":"none"});
            }else {
                $("#sendVerifyCode").css({color:"#d4d5d6"});
                $(".cloth1").css({"display":"block"});
            }
            if(code.length ===6 && len === 11 && check){
                $(".cloth2").css({display:"none"});
            }else {
                $(".cloth2").css({display:"block"});
            }

    });
   
    $(".cloth2").click(function () {
        var check = $("#check").prop("checked");
        if (!check){
            $(".prompt_message").css({display:"block"});
            setTimeout(function () {
                $(".prompt_message").css({display:"none"});

            },2000);
        }
    });

    $("#verifyCode").keyup(function () {
            var number = $("#input_number").val();
            var code = $(this).val();
            var check = $("#check").prop("checked");
            if(code.length === 6 && number.length === 11 && check){
                $(".cloth2").css({display:"none"});
            }else {
                $(".cloth2").css({display:"block"});
            }
    });

    $("#check").click(function () {
            var number = $("#input_number").val();
            var code = $("#verifyCode").val();
            var check = $(this).prop("checked");
            if(code.length === 6 && number.length === 11 && check){
                $(".cloth2").css({display:"none"});
            }else {
                $(".cloth2").css({display:"block"});
            }
    });
	
	//短信验证码倒计时
    var countdownHandler = function(){
    	
        var $button = $("#sendVerifyCode");
        var number = 60;
        var countdown = function(){
            if (number === 0) {
            	$("#sendVerifyCode").css({color:"#47a9ff"});
                $(".cloth1").css({"display":"none"});
                $button.attr("disabled",false);
                $button.html("获取验证码");
                number = 60;
                return;
            } else {
            	$("#sendVerifyCode").css({color:"#d4d5d6"});
                $(".cloth1").css({"display":"block"});
                $button.attr("disabled",true);
                $button.html(number + " s");
                number--;
            }
            setTimeout(countdown,1000);
        };
        setTimeout(countdown,1000);
        
    };

    //发送短信验证码
    $(".sendVerifyCode").on("click", function(){
        var $number = $("#input_number");
        var data = {};
        data.number = $.trim($number.val());
        var reg = /^1\d{10}$/;
        if(!reg.test(data.number)){
            alert('请输入合法的手机号码');
            return ;
        }
        $.ajax({
            url: getBasePath()+"user/sendSms.action",
            async : true,
            type: "post",
            dataType: "text",
            data: data,
            success: function (data) {
                if(data === 'success'){
                    countdownHandler();
                    return ;
                }else{
                	alert("短信发送失败！")
                }
                
                
            }
        });
    });
    
    //提交
    $("#button").on("click", function(){
        var data = {};
        data.number = $.trim($("#input_number").val());
        data.verifyCode = $.trim($("#verifyCode").val());
        $.ajax({
            url: getBasePath()+"user/register.action",
            async : true,
            type: "post",
            dataType: "text",
            data: data,
            success: function (data) {
                if(data === 'success'){
                    parent.location.href=getBasePath() + "index.jsp";
                    return ;
                }
                if(data === 'pending_review'){
                	window.location.href=getBasePath() + "user/pending_review.action";
                    return ;
                }
                if(data === 'prompt_page'){
                	window.location.href=getBasePath() +"user/prompt_page.action";
                	return ;
                }
                alert(data);
            }
        });
    })
});