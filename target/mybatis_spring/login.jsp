<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/9
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main{
            border-bottom-width: medium;
            background-color: bisque;
            position: absolute;
            top:50%;
            left: 50%;
            width: 400px;
            height: 200px;
        }
        body{
            background: url("./img/2.jpg") ;
            background-size: 100% 100%;
        }

    </style>
    <script>
        function changeyzm(obj){
            obj.src="yzm?time="+Date.now();
        };
    </script>
</head>
<body >
        <div class="main">
            <p style="text-align: center">管理员登录</p>
            <hr>
            <span>${msg}</span>
            <form action="login" method="post">
                用户名：<input type="text" name="uName"><br>
                密码：&nbsp;&nbsp;&nbsp;<input type="text" name="uPassword"><br>
                验证码：<input type="text" name="yzm">
                <img src="/ssm/yzm" onclick="changeyzm(this)"><br>
                <input type="submit" value="登录" style="text-align: center">
            </form>
        </div>
</body>
</html>
