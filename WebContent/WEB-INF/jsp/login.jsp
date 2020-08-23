<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录/注册</title>
    <link rel="stylesheet" type="text/css"  href="<%=basePath %>css/login.css"/>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/sendCode.js"></script>
    <script type="text/javascript">
	    function getBasePath(){
	        return '<%=basePath%>';
	    }
    </script>
</head>
<body class="clearfex">
    <div class="box">
        <div class="image">
            <img src="<%=basePath%>images/logo.png">
        </div>
        <div class="text">
            <b>饿了么商家版</b>
        </div>
        <form action="">
            <div class="phoneNumber">
                <input type="text" class="input_number" id="input_number" maxlength="11" placeholder="请输入手机号">
                <button type="button" id="sendVerifyCode" class="sendVerifyCode">获取验证码</button>
                <div class="cloth1"></div>
            </div>
            <div class="code">
               <input type="text" id="verifyCode" class="verifyCode" maxlength="6" placeholder="验证码">
            </div>
            <div class="login">
               <input type="button" value="注册/登录" id="button">
                <div class="cloth2"></div>
                <div class="prompt_message">
                    <sapn>请先阅读并同意饿了么【商家版隐私政策】</sapn>
                </div>
            </div>
            <div class="protocol">
                <span class="span1">未注册手机号将自动为您注册</span><br/>
               <input type="checkbox" class="check" id="check"><span class="span2">我已阅读并同意</span><a href="#">饿了么商家版隐私政策</a>
            </div>


        </form>
    </div>
</body>
</html>