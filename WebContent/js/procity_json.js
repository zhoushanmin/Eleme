$(function (){
	
	/*
	 * 这是使用json接收服务器端发送来的数据
	 */
	$("#province").change(function(){
		var adcode = $(this).val();
		$("#city").html("<option value='0'>-请选择-</option>");
		$("#county").html("<option value='0'>-请选择-</option>");
		if(adcode != "0"){
			$.post(getPath()+"place/finAllCity.action",{adcode:adcode},function(data,status){
				$(data.city).each(function(index, place){
				$("#city").append("<option value="+place.citycode+">"+place.name+"</option>");
				});
			},"json");
		}
	});
	
	$("#city").change(function(){
		var citycode = $(this).val();
		$("#county").html("<option value='0'>-请选择-</option>");
		if(citycode != "0"){
			$.post(getPath()+"place/findAllCounty.action",{citycode:citycode},function(data,status){
				$(data.county).each(function(index, place){
				$("#county").append("<option value="+place.citycode+">"+place.name+"</option>");
				});
			},"json");
		}
	});
	
});