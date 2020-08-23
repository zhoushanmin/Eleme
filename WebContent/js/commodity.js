function find(id) {
	$('#dg').datagrid({    
	    url:"../commodity/findCommoditysByCateId.action?id="+id,    
	    columns:[[    
	        {field:'commodity_name',title:'商品名称',width:100},    
	        {field:'commodity_jianjie',title:'商品简介',width:100},    
	        {field:'commodity_price',title:'商品价格',width:100},
	        {field:'commodity_pic',title:'商品图片',width:100},
	        {field:'commodity_cate_name',title:'商品类别',width:100},
	        {field:'xxx',title:'操作',width:100,formatter: function(value,row,index){
				return "<a href='#' onclick='edit("+row.id+")'>修改</a> | <a href='#' onclick='del("+row.id+")'>删除</a>";
			}
		}
	    ]],
	 // 显示分页工具条
        pagination:true,
        // 初始化的页数
        pageNumber:1,
        // 每页显示记录数:
        pageSize:10,
        // 分页工具条中下拉列表中的值：
        pageList:[10,15,20],
        // 隔行换色
        striped:true,
        toolbar: [{
    		iconCls: 'icon-add',
    		handler: function(){
    			// 弹出窗口:
				$("#winAdd").window("open");
				$("#commodity_name").val('');
				$("#commodity_jianjie").val('');
				$("#commodity_price").val('');
				$("#image1").attr("src",getPath() + "images/addImg.jpg" );
				$("#hidden").val(id);
    		}
    	},
    	{
    		iconCls: 'icon-search',
    		handler: function(){
    			// 弹出窗口:
				$("#winSearch").window("open");
				$("#hidden").val(id);
    		}
    	}]
	}); 
};

function search() {
	var commo_name= $("#search").val();
	$('#dg').datagrid({    
	    url:"../commodity/findCommoditysByName.action?commo_name="+commo_name,    
	    columns:[[    
	        {field:'commodity_name',title:'商品名称',width:100},    
	        {field:'commodity_jianjie',title:'商品简介',width:100},    
	        {field:'commodity_price',title:'商品价格',width:100},
	        {field:'commodity_pic',title:'商品图片',width:100},
	        {field:'commodity_cate_name',title:'商品类别',width:100},
	        {field:'xxx',title:'操作',width:100,formatter: function(value,row,index){
				return "<a href='#' onclick='edit("+row.id+")'>修改</a> | <a href='#' onclick='del("+row.id+")'>删除</a>";
			}
		}
	    ]],
	 // 显示分页工具条
        pagination:true,
        // 初始化的页数
        pageNumber:1,
        // 每页显示记录数:
        pageSize:10,
        // 分页工具条中下拉列表中的值：
        pageList:[10,15,20],
        // 隔行换色
        striped:true,
        toolbar: [{
    		iconCls: 'icon-add',
    		handler: function(){
    			// 弹出窗口:
				$("#winAdd").window("open");
				$("#sChannel2").val('');
				$("#hidden").val(id);
    		}
    	},
    	{
    		iconCls: 'icon-search',
    		handler: function(){
    			// 弹出窗口:
				$("#winSearch").window("open");
				$("#hidden").val(id);
    		}
    	}]
	}); 
	$("#winSearch").window("close");
};

function save(){
	
	if($("#commodity_name").val() === ""){
		alert("请输入商品名称！");
		return;
	}
	if($("#commodity_jianjie").val() === ""){
		alert("请输入商品简介！");
		return;
	}
	if($("#commodity_price").val() === ""){
		alert("请输入商品价格！");
		return;
	}
	if($("#file").val() === ""){
		alert("请上传商品图片！");
		return;
	}
	
	$('#formAdd').form({    
	    url:"../commodity/addCommodity.action",    
	    success:function(data){    
	       var jsonData = eval("("+data+")");
	       $.messager.show({
	    		title:'提示消息',
	    		msg:jsonData.msg,
	    		timeout:3000,
	    		showType:'slide'
	    	});
	    	// 关闭窗口:
	    	$("#winAdd").window("close");
	    	// 重新加载数据:
	    	$("#dg").datagrid("reload");
	    }    
	});    
	// submit the form    
	$('#formAdd').submit();  
}

function edit(id){
	// alert(id);
	$("#winUpdate").window("open");
	document.getElementById("file2").value="";
	$.post(getPath() + "commodity/findCommodityById.action",
			{id:id},
			function(data){
				$("#id").val(data.id);
				$("#commodity_name1").val(data.commodity_name);
				$("#commodity_jianjie1").val(data.commodity_jianjie);
				$("#commodity_price1").val(data.commodity_price);
				$("#image2").attr("src",getPath() + "commodity/showPic.action?pic=" + data.commodity_pic);
			},
			"json"
	);
}

function update(){
	if($("#commodity_name1").val() === ""){
		alert("商品名称不能为空！");
		return;
	}
	if($("#commodity_jianjie1").val() === ""){
		alert("商品简介不能为空！");
		return;
	}
	if($("#commodity_price1").val() === ""){
		alert("商品价格不能为空！");
		return;
	}
	
	$('#formUpdate').form({    
	    url:"../commodity/updateCommodity.action",    
	    success:function(data){    
	       var jsonData = eval("("+data+")");
	       $.messager.show({
	    		title:'提示消息',
	    		msg:jsonData.msg,
	    		timeout:3000,
	    		showType:'slide'
	    	});
	    	// 关闭窗口:
	    	$("#winUpdate").window("close");
	    	// 重新加载数据:
	    	$("#dg").datagrid("reload");
	    }    
	});    
	// submit the form    
	$('#formUpdate').submit();  
}

function del(id){
	var flag = confirm("是否确定删除");
    if(flag){
    	$.post(getPath() + "commodity/deleteCommodity.action",{"id":id},function(data){
			$.messager.show({
	    		title:'提示消息',
	    		msg:data.msg,
	    		timeout:5000,
	    		showType:'slide'
	    	});
			$("#dg").datagrid("reload");
		},"json");
    }
}

function addCateWin() {
	$("span").remove(".span1");
	$("#winAddCate").window("open");
}

function editCateWin(id) {
	$("span").remove(".span1");
	$.post("../commodity_cate/findCateNameById.action",
			{
				id:id
			},
			function(data,status){
				$("#winEditCate").window("open");
				$("#editCate").val(data.cateName);
				$("#hidden2").val(id);
				
			},"json");
}

/* 显示品类列表 */
function showCateList(data) {
	$("#tbody").empty();
	$("#tbody").append("<tr><td colspan='2' style='padding:2px'><a href='javascript:void(0);'  class='addCate' onclick='addCateWin()''></a></td></tr>");
	$("#tbody").append("<tr><td  style='width: 60%'>品类</td><td>操作</td></tr>");
	
	$.each(data,function(i,cate){
		$("#tbody").append("<tr><td class='tda'>" + 
        		"<a href='javascript:void(0);' onclick='find("+cate.id+")'> " + cate.commodity_cate_name +"</a>" +
            "</td><td><a href='#' onclick=editCateWin(" +cate.id +")>编辑</a> | <a href='#' onclick=delCate(" +cate.id +")>删除</a></td></tr>");
	});
	$("#cate").val("");
}

function addCate() {
	var cate = $("#cate").val();
	if(cate != ""){
		$.post("../commodity_cate/addCate.action",
				{
					cate:cate
				},
				function(data,status){
					$.messager.show({
	    	    		title:'提示消息',
	    	    		msg:data.msg,
	    	    		timeout:5000,
	    	    		showType:'slide'
	    	    	});
					showCateList(data.list);
					$("#winAddCate").window("close");
					$("#cate").val('');
					
				},"json");
	}else{
		$("span").remove(".span1");
		$("#cate").after("<span class='span1' style='color:red;margin-left:5px;'>商品类别不能为空</span>");
	}
}
	
function delCate(id) {
	var userId = $("#hidden_userId").val();
	var flag = confirm("是否确定删除");
    if(flag){
    	$.post("../commodity/deleteCate.action",{"cateId":id},function(data){
			$.messager.show({
	    		title:'提示消息',
	    		msg:data.msg,
	    		timeout:5000,
	    		showType:'slide'
	    	});
			showCateList(data.list);
			find(id);
		},"json");
    }
}

function editCate() {
	var cateName = $("#editCate").val();
	var cateId = $("#hidden2").val();
	if(cateName != ""){
		$.post("../commodity_cate/updateCate.action",
				{
					cateId:cateId,
					cateName:cateName
				},
				function(data,status){
					$.messager.show({
	    	    		title:'提示消息',
	    	    		msg:data.msg,
	    	    		timeout:5000,
	    	    		showType:'slide'
	    	    	});
					showCateList(data.list);
					$("#winEditCate").window("close");
					
				},"json");
	}else{
		$("span").remove(".span1");
		$("#editCate").after("<span class='span1' style='color:red;margin-left:5px;'>商品类别不能为空</span>");
	}
}

$(function () {
	$("#file").change(function () {
	    var filePath = $(this).val();
	    var fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
	    // 检查是否是图片
	    if( !fileFormat.match(/.png|.jpg|.jpeg|.gif/) ) {
	        alert('上传错误,文件格式必须为：png/jpg/jpeg/gif');
	        return;
	    }
	    var src = window.URL.createObjectURL(this.files[0]);
	    $("#image1").attr("src",src);
	});
	
	$("#file2").change(function () {
	    var filePath = $(this).val();
	    var fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();
	    // 检查是否是图片
	    if( !fileFormat.match(/.png|.jpg|.jpeg|.gif/) ) {
	        alert('上传错误,文件格式必须为：png/jpg/jpeg/gif');
	        return;
	    }
	    var src = window.URL.createObjectURL(this.files[0]);
	    $("#image2").attr("src",src);
	});
});

function selectPic() {
    $("#file").click();
}

function selectPic2() {
    $("#file2").click();
}

