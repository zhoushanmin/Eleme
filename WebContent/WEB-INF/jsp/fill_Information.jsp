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
	<title>填写信息</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath %>css/fill_information.css">
	<script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/fill_information.js"></script>
	<script type="text/javascript" src="<%=basePath %>js/procity_json.js"></script>
	<script type="text/javascript">
		function getPath() {
			return "<%=basePath%>";
		}
	</script>
</head>
<body class="clearfex">
	<a id="mao"></a>
    <div class="box">
        <ul class="ul01" id="ul01">
            <li><p class="p1">1</p><span class="span1">门店信息</span></li>
            <li><p class="p1">2</p><span class="span1">资质证照</span></li>
            <li><p class="p1">3</p><span class="span1">开店人</span></li>
        </ul>
        <form action="<%=basePath%>user/saveUserInformation.action" method="post" enctype="multipart/form-data" onsubmit="return toVaild()">

            <div class="mendianxinxi">
                <table border="0" class="table01">
                    <tbody>
                    <tr>
                        <td colspan="2">
                            <p class="p2">准确填写牌匾名、地址和类目，业务经理会尽快联系您</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="tiaomu">
                            基本信息
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan">
                            <span>*</span>线下店铺牌匾名
                        </td>
                        <td><input class="input1" type="text" placeholder="需与门脸照牌匾一致" name="shop_name" id="shop_name"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="4" width="35%" class="ziduan"><span>*</span>门店地址</td>
                        <td>
                            <p class="p3">文本地址需与许可证上经营的场所保持一致， 否则审核不通过</p>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input class="input2" type="text" value="省 - 市 - 区/县" readonly name="ssq" id="input2">
                            <div class="bu">
                                <div class="shengshi" id="shengshi">
                                    <input type="button" value="×关闭" id="quxiao" class="quxiao">
                                    <div class="sheng">
                                        <label>省:</label>
                                        <select name="province" id="province">
                                            <option value="0">-请选择-</option>
                                                <c:forEach items="${list }" var="place">
									            	<option value="${place.adcode }">${place.name }</option>
									            </c:forEach>
                                        </select>
                                        <label>市:</label>
                                        <select name="city" id="city">
                                            <option value="0">-请选择-</option>
                                        </select>
                                        <label>县/区:</label>
                                        <select name="county" id="county">
                                            <option value="0">-请选择-</option>
                                        </select><br>
                                        <input type="button" value="确定" id="sure">
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td><input class="input1" style="height: 30px" type="text" placeholder="请填写门店详细地址" name="detailed_address" id="detailed_address"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="tiaomu">
                            经营信息
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>营业类目</td>
                        <td>
                        	<input class="input1" type="text" placeholder="请填写经营品类" name="business_category" id="business_category">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>门脸照</td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image1">
                            <input type="file" id="file1" class="file" name="imgFile">
                            <p class="p4">建议拍摄营业中的商户门面;照片需清晰，无黑、白、
                                彩色边框;需拍全，包含完整的牌匾，门槛（建议正对门店2米处拍摄）</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>店内照</td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image2">
                            <input type="file" id="file2" class="file" name="imgFile">
                            <p class="p4">需真实反映堂食区域（餐桌、餐椅等）</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>门店LOGO</td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image3">
                            <input type="file" id="file3" class="file" name="imgFile">
                            <p class="p4">图片需与商家实际经营相关</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>外卖电话</td>
                        <td><input class="input1" type="text" placeholder="请输入外卖电话" name="take_out_phone" id="take_out_phone"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>联系人姓名</td>
                        <td><input class="input1" type="text" placeholder="请填写门店经营者的姓名" name="contact_name" id="contact_name"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>联系电话</td>
                        <td><input type="text" maxlength="11" id="number" readonly value="${sessionScope.verifyCode.number}" name="contact_number"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;height: 40px">
                            <a href="#mao" type="button" id="btn1" class="btn">下一步</a>
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>

            <div class="zizhizhengzhao">
                <table border="0" class="table01">
                    <tbody>
                    <tr>
                        <td colspan="2" class="tiaomu">
                            主体资质
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan" width="35%">
                            <span>*</span>证件类型
                        </td>
                        <td><input class="input1" type="text" placeholder="证件类型" name="main_document_type" id="main_document_type"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>证件照片</td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image4">
                            <input type="file" id="file4" class="file" name="imgFile">
                            <p class="p4">照片需清晰，完整拍摄国徽和红章，
                                无水印，文字清晰，复印件需加盖红色公章</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="tiaomu">
                            行业资质
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan">
                            <span>*</span>证件类型
                        </td>
                        <td><input class="input1" type="text" placeholder="证件类型" name="industry_document_type" id="industry_document_type"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>证件照片</td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image5">
                            <input type="file" id="file5" class="file" name="imgFile">
                            <p class="p4">照片需清晰，完整拍摄国徽和红章，
                                无水印，文字清晰，复印件需加盖红色公章</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;height: 40px">
                            <input type="button" value="上一步" id="btn2" class="btn1">
                            <input type="button" value="下一步" id="btn3" class="btn">
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>

            <div class="kaidianren">
                <table border="0" class="table01">
                    <tbody>
                    <tr>
                        <td colspan="2" class="tiaomu">
                            基本信息
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan" width="35%">
                            <span>*</span>姓名
                        </td>
                        <td><input class="input1" type="text" placeholder="需与身份证一致" name="user_name" id="user_name"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan" width="35%">
                            <span>*</span>性别
                        </td>
                        <td>
                            <input type="radio" name="user_sex" value="男" checked>男
                            <input type="radio" name="user_sex" value="女">女
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan" width="35%">
                            <span>*</span>民族
                        </td>
                        <td><input class="input1" type="text" placeholder="需与身份证一致" name="user_nation" id="user_nation"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan" width="35%">
                            <span>*</span>出生年月
                        </td>
                        <td><input class="input1" type="text" placeholder="格式：××××-××" name="user_birthday" id="user_birthday"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan" width="35%">
                            <span>*</span>家庭住址
                        </td>
                        <td><input class="input1" type="text" placeholder="常住地址" name="user_home_address" id="user_home_address"></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan"><span>*</span>身份证件正面照片</td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image6">
                            <input type="file" id="file6" class="file" name="imgFile">
                            <p class="p4">清晰拍摄身份证信息拍摄完整，不
                        可有遮盖物遮挡可使用临时身份证/护
                        照/港澳居民往来大陆通行证/台胞证
                        等证件</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan">
                            <span>*</span>身份证件反面照片
                        </td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image7">
                            <input type="file" id="file7" class="file" name="imgFile">
                            <p class="p4">需清晰拍摄身份证有效期信息拍摄完整，不可有遮盖物遮挡</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td class="ziduan">
                            <span>*</span>手持身份证正面照片
                        </td>
                        <td>
                            <img src="<%=basePath %>images/addImg.jpg" alt="添加图片" class="image" id="image8">
                            <input type="file" id="file8" class="file" name="imgFile">
                            <p class="p4">需开店人本人手持需清晰拍摄开店人正面五官及身份证信息</p>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <hr>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;height: 40px">
                            <input type="button" value="上一步" id="btn4" class="btn1">
                            <input type="submit" value="完成" id="btn5" class="btn">
                        </td>
                    </tr>
                    </tbody>
                </table>

            </div>

        </form>

    </div>
</body>
</html>