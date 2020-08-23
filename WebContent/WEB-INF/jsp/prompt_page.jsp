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
    <title>填写信息</title>
    <script type="text/javascript" src="<%=basePath %>js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#check").on("click",function () {
                var flag = $(this).prop("checked");
                if (flag){
                    $(".bu").css({display:"none"});
                }else{
                    $(".bu").css({display:"block"});
                }
            });
            
        })
    </script>
    <style type="text/css">
        body{
            margin: 0;
            padding: 0;
        }
        .clearfex:before{
            content: "";
            display: table;
        }
        .box{
            width: 600px;
            height: 1200px;
            margin: 50px auto;

        }
        .table01{
            width: 100%;
        }

        .td1 p{
            text-align: center;
            margin: 0;
        }
        .td1 p:nth-child(2){
            font: 24px/24px "Microsoft YaHei UI";
            margin: 8px 0;
        }
        .td1 p:nth-child(3){
            margin-bottom: 20px;
        }
        .table01 tr > td:nth-child(2){
            text-align: center;
        }
        .table01 tr > td:nth-child(1) span{
            font-size: 12px;
            color: rgba(73,75,75,0.78);
        }
        .td9{
            text-align: center;
            padding-top: 10px;
            font-size: 12px;
        }
        .td9 .a1{
            color: #0b81f7;
            text-decoration: none;

        }
        .td9 .a1:hover{
            color: #2db3ff;
        }
        .btn{
        	display: inline-block;
            text-decoration: none;
            background-color: #0b81f7;
            width: 60%;
            height: 30px;
            color: #ffffff;
            font: 16px/30px "Microsoft YaHei UI";
            border-radius: 15px 15px;
            margin: 10px 0;
        }
        .bu{
            position: absolute;
            width: 60%;
            height: 40px;
            background: rgba(255,255,255,0.5);
            top: 37px;
            left: 120px;
            border-radius: 15px 15px;
        }
        hr{
            border: 1px solid #d6d7d7;
        }


    </style>

</head>
<body class="clearfex">

    <div class="box">

        <table class="table01" cellSpacing=0 cellPadding=5  border=0>
            <tbody>
            <tr>
                <td colspan="2" class="td1">
                    <p>开店前请准备好以下</p>
                    <p><b>7种图片资料</b></p>
                    <p>以便您更顺畅的完成申请并通过审核</p>
                </td>

            </tr>
            <tr>
                <td width="60%">
                    <p><b>1.门脸照片</b></p>
                    <span>需拍出完整牌匾、门框，建议距离门店2米外拍摄</span>
                </td>
                <td><img src="<%=basePath %>images/1.jpeg" alt="" width="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td>
                    <p><b>2.店内环境照片</b></p>
                    <span>需真实反映用餐环境，拍摄整体就餐区域，请勿局部拍摄桌椅</span>
                </td>
                <td><img src="<%=basePath %>images/2.jpeg" alt="" width="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td>
                    <p><b>3.开店人身份证正面照片</b></p>
                    <span>需清晰拍摄身份证信息拍摄完整，不
                        可有遮盖物遮挡可使用临时身份证/护
                        照/港澳居民往来大陆通行证/台胞证
                        等证件</span>
                </td>
                <td><img src="<%=basePath %>images/3.png" alt="" width="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td>
                    <p><b>4.开店人身份证反面照片</b></p>
                    <span>需清晰拍摄身份证有效期信息拍摄完整，不可有遮盖物遮挡</span>
                </td>
                <td><img src="<%=basePath %>images/4.png" alt="" width="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td>
                    <p><b>5.开店人手持身份证正面照片</b></p>
                    <span>需开店人本人手持需清晰拍摄开店人正面五官及身份证信息</span>
                </td>
                <td><img src="<%=basePath %>images/5.jpg" alt="" width="150px" height="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td>
                    <p><b>6.营业执照</b></p>
                    <span>需清晰拍摄营业执照信息图片完整无遮盖物遮挡，
                        上见国徽， 下见红章勿包含人物肖像、身份证或其他信息</span>
                </td>
                <td><img src="<%=basePath %>images/6.png" alt="" width="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td>
                    <p><b>7.许可证</b></p>
                    <span>需清晰拍摄许可证信息图片完整无遮盖物遮挡，上见国徽，
                        下见红章勿包含人物肖像、身份证或其他信息可使用当地监管
                        部门认可的、具有同《食品经营许可证》同等法律效力的证件</span>
                </td>
                <td><img src="<%=basePath %>images/7.png" alt="" width="150px"></td>
            </tr>
            <tr><td colspan="2"><hr/></td></tr>
            <tr>
                <td colspan="2" class="td9" style="position: relative;">
                    <input type="checkbox" id="check">
                    <span>我已阅读并同意&nbsp;<a href="" class="a1">《饿了么网上订餐平台服务协议》</a></span><br/>
                    <a href="<%=basePath %>place/getFill_information.action" id="btn" class="btn" >准备好了，进入下一步</a>
                    <div class="bu"></div>
                </td>
            </tr>
            </tbody>
        </table>

    </div>
</body>
</html>