<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Integer id = 1;
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>折线图</title>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>js/echarts.min.js"></script>
    <script type="text/javascript">
    	
    	$(function() {
    		$.post("../commodity/findAllCommodityTotalSales.action",
    				{
    					id:1
    				}
    				,
    				function (data) {
    					tuxing(data);
    				},"json");
		})

	    function tuxing(data) {
    		var myChart = echarts.init(document.getElementById('main'));
            var option = {
            		title:{
    		            text:'各商品总销售情况'
    		        },
                   dataset: {
                       source: data.data
                   },
                   grid: {containLabel: true},
                   xAxis: {},
                   yAxis: {type: 'category'},
                   series: [
                       {
                           type: 'bar',
                           encode: {
                               // 将 "amount" 列映射到 X 轴。
                               x: 'totalSales',
                               // 将 "product" 列映射到 Y 轴。
                               y: 'name'
                           },
                           itemStyle: {
   							normal: {
   								label: {
   									show: true, //开启显示
   									position: 'right', //在右方显示
   									textStyle: { //数值样式
   										color: 'red',
   										fontSize: 16
   									}
   								}
   							}
   						}
                       }
                   ]
               };
             myChart.setOption(option);
		}
	  

    </script>
    <style type="text/css">
        .box{
            margin: 0 auto;
        }
        .select{
            width: 70%;
            margin: 20px auto;
        }
    </style>
    
</head>
<body>
    <!--为echarts准备一个容器，画图就画在里面-->
    <div id="main" class="box" style="width: 90%;height: 800px;">
    </div>
</body>
</html>