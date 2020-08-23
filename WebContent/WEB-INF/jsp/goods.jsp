<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/my.css">
<script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/commodity.js"></script>
<script type="text/javascript" src="<%=basePath %>locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	function getPath() {
		return "<%=basePath%>";
	}
</script>
</head>
<body>
	<div id="cc" class="easyui-layout" data-options="fit:true">           
	    <div data-options="region:'west',title:'商品类别',split:true" style="width:200px;">
	    	<table id=“table1” class="table1" cellSpacing=0 cellPadding=5>
		        <tbody id="tbody">
		        	<tr><td colspan="2" style="padding:2px"><a href='javascript:void(0);'  class="addCate" onclick="addCateWin()"></a></td></tr>
			        <tr><td  style="width: 60%">品类</td><td>操作</td></tr>
			        
			        <c:forEach items="${list }" var="cate">
					    <tr>
				        	<td class="tda">
				        		<a href='javascript:void(0);' onclick='find("${cate.id}")'> ${cate.commodity_cate_name }</a>
				            </td>
				            <td>
				                <a href="#" onclick="editCateWin(${cate.id})">编辑</a> | <a href="#" onclick="delCate(${cate.id})">删除</a>
				            </td>
				        </tr>
					</c:forEach>
		        </tbody>
		    </table>
		    
		    <!-- 添加品类，默认隐藏 -->
		    <div id="winAddCate" class="easyui-window" title="添加商品类别" style="width:600px;height:100px"   
		        data-options="iconCls:'icon-save',modal:true,closed:true">   

					<TABLE cellSpacing=0 cellPadding=5  border=0>
					<TR>
						<td>品类名称：</td>
						<td>
							<INPUT class=textbox id="cate" style="WIDTH: 180px" maxLength=50 name="commodity_name">
						</td>
						<tr>
							<td rowspan=2>
								<button id="customerBtn" type="button" onclick="addCate()">添加</button>
							</td>
						</tr>
					</TABLE>   
			</div>
			
			<!-- 修改品类名称，默认隐藏 -->
		    <div id="winEditCate" class="easyui-window" title="修改品类名称" style="width:600px;height:100px"   
		        data-options="iconCls:'icon-save',modal:true,closed:true">   
			    
					<input id="hidden2" type="hidden" name="commodity_cate_id">
					<TABLE cellSpacing=0 cellPadding=5  border=0>
					<TR>
						<td>品类名称：</td>
						<td>
							<INPUT class=textbox id="editCate" style="WIDTH: 180px" maxLength=50 name="commodity_name">
						</td>
						<tr>
							<td rowspan=2>
								<button id="customerBtn" type="button" onclick="editCate()">修改</button>
							</td>
						</tr>
					</TABLE>   
			</div>
			
	    </div>   
	    
	    <div data-options="region:'center',title:'商品'" style="padding:5px;background:#eee;">
	    	<table id="dg"></table>  
	    	<!-- 添加商品的表单，默认是隐藏的 -->
			<div id="winAdd" class="easyui-window" title="添加商品" style="width:600px;height:400px"   
		        data-options="iconCls:'icon-save',modal:true,closed:true">   
			    
		        <form id="formAdd" method="post" enctype="multipart/form-data">
					<input id="hidden" type="hidden" name="commodity_cate_id" value="">
					<TABLE cellSpacing=0 cellPadding=5  border=0>
					<TR>
						<td>商品名称：</td>
						<td>
							<INPUT class=textbox id=commodity_name style="WIDTH: 180px" maxLength=50 name="commodity_name">
						</td>
						<td>商品简介 ：</td>
						<td>
							<INPUT class=textbox id=commodity_jianjie style="WIDTH: 180px" maxLength=50 name="commodity_jianjie">
						</td>
					</TR>
					
					<TR>
						<td>商品价格 ：</td>
						<td>
							<INPUT class=textbox id=commodity_price style="WIDTH: 180px" maxLength=50 name="commodity_price">
						</td>
						<td>商品图片：</td>
						<td>
							<img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image1" id="image1" style="WIDTH: 100px;height:100px" onclick="selectPic()">
							<INPUT class=textbox  type="file" id="file" style="WIDTH: 180px;display:none" maxLength=50 name="good_pic">
						</td>
					</TR>
						
						<tr>
							<td rowspan=2>
								<button id="customerBtn" type="button" onclick="save()">保存</button>
							</td>
						</tr>
					</TABLE>   
				</form>
			</div>
			
			<!-- 查找商品的表单，默认是隐藏的 -->
			<div id="winSearch" class="easyui-window" title="查找商品" style="width:600px;height:100px"   
		        data-options="iconCls:'icon-save',modal:true,closed:true">   
			    
					<input id="hidden" type="hidden" name="commodity_cate_id" value="">
					<TABLE cellSpacing=0 cellPadding=5  border=0>
					<TR>
						<td>商品名称：</td>
						<td>
							<INPUT class=textbox id=search style="WIDTH: 180px" maxLength=50 name="commodity_name">
						</td>
						<tr>
							<td rowspan=2>
								<button id="customerBtn" type="button" onclick="search()">查询</button>
							</td>
						</tr>
					</TABLE>   
			</div>
			
			<!-- 更新商品的表单，默认是隐藏的 -->
			<div id="winUpdate" class="easyui-window" title="修改商品" style="width:600px;height:400px"   
		        data-options="iconCls:'icon-save',modal:true,closed:true">   
			    
		        <form id="formUpdate" method="post" enctype="multipart/form-data">
		        	<input type="hidden" name="id" id="id"/>
					<TABLE cellSpacing=0 cellPadding=5  border=0>
					<TR>
						<td>商品名称：</td>
						<td>
							<INPUT class=textbox id=commodity_name1 style="WIDTH: 180px" maxLength=50 name="commodity_name">
						</td>
						<td>商品简介 ：</td>
						<td>
							<INPUT class=textbox id=commodity_jianjie1 style="WIDTH: 180px" maxLength=50 name="commodity_jianjie">
						</td>
					</TR>
					
					<TR>
						<td>商品价格 ：</td>
						<td>
							<INPUT class=textbox id=commodity_price1 style="WIDTH: 180px" maxLength=50 name="commodity_price">
						</td>
						<td>商品图片：</td>
						<td>
							<img src="<%=basePath %>images/addImg.jpg" alt="添加图片" id="image2" style="WIDTH: 100px;height:100px" onclick="selectPic2()">
							<INPUT class=textbox  type="file" id=file2 style="WIDTH: 180px;display:none" maxLength=50 name="good_pic">
						</td>
					</TR>
						
						<tr>
							<td rowspan=2>
								<button id="customerBtn" type="button" onclick="update()">保存</button>
							</td>
						</tr>
					</TABLE>   
				</form>
			</div>
			
	    </div>   
	</div>  
</body>
</html>