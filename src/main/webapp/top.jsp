<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/9
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            background: url("./img/4.jpg") ;
            background-size: 100% 100%;
        }
        .admin{
            position:absolute;
            right:0px;
            top:0px
        }
    </style>
</head>
<body >
<h1 style="text-align: center">酒店管理系统</h1>
<span class="admin">
    欢迎：${admin.user}<a href="/ssm/exitLogin" target="_parent">退出登录</a>
</span>
</body>
</html>
