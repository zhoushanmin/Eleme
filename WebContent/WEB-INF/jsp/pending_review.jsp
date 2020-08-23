<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>待审核</title>
    <style type="text/css">

        body,ul{
            margin: 0;
            padding: 0;
        }
        ul{
            list-style: none;
        }
        .box{
            width: 500px;
            height: 100px;
            margin: 100px auto;
        }
        p{
            margin: 0;
        }
        .p1{
            color: #3aac4a;
        }
        .p1 span{
            display: inline-block;
            width: 20px;
            height: 20px;
            border-radius: 10px 10px;
            background-color: #3aac4a;
            margin-right: 10px;
            color: #ffffff;
            text-align: center;
        }
        .p2{
            margin: 20px 0;
        }

    </style>
</head>
<body>

    <div class="box">
        <p class="p1"><span>√</span>已提交申请，等待审核</p>
        <p class="p2">我们在24小时内将审核结果通过短信通知您，请注意查收！</p>
    </div>

</body>
</html>