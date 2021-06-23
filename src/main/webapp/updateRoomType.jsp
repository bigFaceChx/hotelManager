<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/12
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<form action="updateRoomType">
        <table>
            <tr>
                <td>编号</td>
                <td>类型</td>
                <td>价格</td>
                <td>操作</td>
            </tr>
            <tr>
                <input name="oldRt" style="display: none" value="<%=request.getParameter("roomType")%>"/>
                <td><input name="roomType" value="<%=request.getParameter("roomType")%>"></td>
                <td><input name="name" value="<%=request.getParameter("name")%>"></td>
                <td><input name="price" value="<%=request.getParameter("price")%>"></td>
                <td><input type="submit" value="修改"/></td>
            </tr>
        </table>
</form>
</body>
<style>
    table{
        border-collapse: collapse;
    }
    table,tr,td{
        border:1px solid black;
    }
</style>
</html>
