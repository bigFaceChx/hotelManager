<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/12
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script  src="js/jquery.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $.ajax({
                url:"findRoomType",
                type:"post",
                dataType:"json",
                success:function (data) {
                    var rt=$(".rt");
                    for (var o in data){
                        var tr="<tr>" +
                            "<td>"+data[o].roomType+"</td>" +
                            "<td>"+data[o].name+"</td>" +
                            "<td>"+data[o].price+"</td>" +
                            "<td><a href='updateRoomType.jsp?roomType="+data[o].roomType+"&name="+data[o].name+"&price="+data[o].price+"'>修改</a></td>"+
                            "</tr>";
                        rt.append(tr);
                    }

                }
            });
        })
        function addRt() {
            var display=$("[action=addRoomType]").css("display");
            if (display=="none"){
                $("[action=addRoomType]").css('display','block');
            }else {
                $("[action=addRoomType]").css('display','none');
            }
        }

    </script>
</head>
<body>
<button onclick="addRt()">添加类型</button>
<form action="addRoomType" style="display: none">
    房间类型：<input name="name">
    价格：<input name="price">
    <input type="submit" value="添加">
</form>
    <table class="rt">
        <tr>
            <td>编号</td>
            <td>类型</td>
            <td>价格</td>
            <td>操作</td>
        </tr>
    </table>
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
