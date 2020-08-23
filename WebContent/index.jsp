<%@page import="com.eleme.bean.Shop"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>饿了么商家版</title>
<!-- 引入EasyUI的CSS和JS -->
<link rel="stylesheet" type="text/css" href="./themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./themes/icon.css">
<script type="text/javascript" src="./js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="./js/jquery.easyui.min.js"></script>
<style>
	.menuA{
		text-decoration:none;
	}
	.ul1{
		list-style: none;
		margin: 0;
		padding: 0;
	}
	.ul1 li{
		margin: 5px 0;
	}
	.header{
            height: 42px;
            background-color: #e0ecff;
        }
        .p1{
            margin: 10px;
            display: inline-block;
            float: right;
            font-size: 14px;
        }
        .span1{
            display: inline-block;
            margin: 8px 20px;
            font-size: 18px;
        }
        .span2{
            display: inline-block;
            margin-right: 10px;
        }
        .span3 a{
            text-decoration:none;
        }
        .span3 a:hover{
            color: deepskyblue;
        }
        .foot p{
        	text-align: center;
        	margin: 10px;
        }
</style>
<script type="text/javascript">
	$(function(){
		$(".menuA").click(function(){
			var user = "<%=session.getAttribute("shop")%>";
			var textContent;
			if(user == "null"){
				parent.location.href=getBasePath() + "user/toLogin.action";
				return false;
			}else{
				// 获得超链接中的文本内容
				textContent = this.innerHTML;
				// 获得请求路径
				var url = this.href;
				// alert(url);
				// 创建选项卡
				createTabs(textContent,url);
				// 让超链接不跳转:
				return false;
			}
	
		});
	});
	
	// 创建选项卡的函数:
	function createTabs(textContent,url){
		// 判断选项卡是否存在
		// 判断选项卡是否存在:
		var flag = $("#tt").tabs("exists",textContent);
		if(flag){
			// 已经存在该选项卡
			$('#tt').tabs("select",textContent);
		}else{
			// 不存在该选项卡
			$('#tt').tabs('add',{    
			    title:textContent,    
			    content:createUrl(url),    
			    closable:true    
			}); 
		}
	}
	
	function createUrl(url){
		return "<iframe src='"+url+"' style='border:0px;width:100%;height:95%;'></iframe>";
	}
	
	function getPath() {
		return "<%=basePath%>";
	}
	
	function quit(){
		var flag = confirm("是否退出本系统？");
	    if(flag){
	    	$.post(getPath() + "user/quit.action",{},function(data){
	    		parent.location.href=getPath() + "index.jsp";
	    	});
	    }
	}
</script>
</head>
<body>

<div id="cc" class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" class="header">
		
			<span  class="span1">饿了么商家管理系统</span>
	        <p class="p1">
	        	<c:if test="${ !empty sessionScope.shop }">
						<span class="span2">${ sessionScope.shop.phone_number }</span>
						<span class="span3"><a href="javascript:void(0);" onclick="quit()">退出</a></span>
				</c:if>
	            <c:if test="${ empty sessionScope.shop }">
					<span class="span3"><a href="<%=basePath %>user/toLogin.action">登录/注册</a></span>
				</c:if>
	        </p>

		</div>
		<div data-options="region:'west',split:true" title="系统菜单" style="width:200px;">
		
			<div id="aa" class="easyui-accordion" data-options="fit:true">   
			    <div title="商品管理" data-options="iconCls:'icon-save',selected:'flase'" style="overflow:auto;padding:10px;">   
			    	<a href="<%=basePath %>commodity_cate/findCommodityCates.action" class="menuA">商品管理</a>
			    </div>     
			    <div title="统计分析" data-options="iconCls:'icon-reload'" style="padding:10px;"> 
			    	<ul class="ul1">
			    		<li>
			    			<a href="<%=basePath %>commodity/findAllCommodity.action" class="menuA">月销售情况</a>  
			    		</li>
			    		<li>
			    			<a href="<%=basePath %>commodity/getCommo_totalSalesJSP.action" class="menuA">总销售情况</a>  
			    		</li>
			    	</ul>
			    </div>   
			    <div title="系统管理" data-options="iconCls:'icon-edit'" style="padding:10px;">   
			    	
			    </div>   
			     <div title="" selected style="padding:10px;"></div>
			</div> 
		
		</div>
		
		<div data-options="region:'center',title:''" style="padding:0px;background:#eee;">
	    	<div id="tt" class="easyui-tabs" data-options="fit:true">
			</div>  
	    </div>
		<div data-options="region:'south',split:true" style="height:70px;" class="foot">
			<p>CopyRight @ 2020 好运来信息技术有限公司 All Rights Reserved</p>
        	<p>电话:010-**********京ICP备*********8号</p>
		</div>
		
	</div> 
</body>
</html>