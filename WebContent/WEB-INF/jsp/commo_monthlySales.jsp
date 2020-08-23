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
    
    	function selectMonthlySales() {
			var id = $("#select1").val();
			var date = $("#date").val();
			$.post("../commodity/findCommodityMonthlySales.action",
				{
					id:id,
					date:date
				},
				function (data) {
					tuxing(data);
				},"json");
		}
    	
	    function tuxing(data) {
	    	//初始化ehcharts实例
		    var myChart=echarts.init(document.getElementById("main"));
		    //指定图表的配置项和数据
		    //指定图标的配置和数据
		    var option = {
		        title:{
		            text:'月销售情况'
		        },
		        tooltip:{},
		        legend:{
		            data:['月销售量']
		        },
		        xAxis:{
		            data:data.month
		        },
		        yAxis:{
		        },
		        series:[{
		            name:'销售量',
		            type:'line',
		            data:data.sales
		        }]
		    };
		
		    //使用制定的配置项和数据显示图表
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
<div class="select">

        <label>商品:</label>
        <select id="select1" name="commo_id">
        	<option value="0" selected="selected">--请选择--</option>
        	<c:forEach items="${list }" var="commo">
        		<option value="${commo.id }">${commo.commodity_name}</option>
        	</c:forEach>
        </select>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <label>自</label>
        <input id="date" type="date" name="begin"/>
        <label>以来</label>
        <input type="button" value="查询" onclick="selectMonthlySales()"/>

    </div>
    <!--为echarts准备一个容器，画图就画在里面-->
    <div id="main" class="box" style="width: 80%;height: 500px;">
    </div>
</body>
</html>