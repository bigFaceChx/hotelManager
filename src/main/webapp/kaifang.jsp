<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/10
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $.ajax({
                url:"findRegister",
                type:"post",
                dataType:"json",
                success:function (data) {
                    for (var o in data){
                        var tr = "<tr>"+
                            "<td>"+data[o].reid+"</td>"+
                            "<td>"+"<img class='roomImg' src="+data[o].img+">"+"</td>"+
                            "<td>"+data[o].rid+"</td>"+
                            "<td>"+data[o].roomType+"</td>"+
                            "<td>"+data[o].uName+"</td>"+
                            "<td>"+data[o].startTime+"</td>";
                        if (data[o].endTime==null){
                            tr+="<td>正在使用</td>";
                        }else{
                            tr+="<td>"+data[o].endTime+"</td>";
                        }
                        tr+=
                            "<td>"+data[o].number+"</td>"+
                            /*"<td><a href='tuifang?reid="+data[o].reid+"&rid="+data[o].rid+"'>退房<a></td>"+*/
                            "<td><a href='deleteRegisterById?reid="+data[o].reid+"'>删除记录</a></td>"+
                            "</tr>";
                        $("#room").append(tr)
                    }
                }
            })
        })
    </script>
</head>
<body>
        <span>${msg}</span>
        <table id="room">
            <tr>
                <td>记录编号</td>
                <td>房间图片</td>
                <td>房间编号</td>
                <td>房间类型</td>
                <td>住房客户</td>
                <td>住房时间</td>
                <td>退房时间</td>
                <td>住房人数</td>

                <td>操作</td>
            </tr>
        </table>
</body>
<style>
    .roomImg{
        width: 100px;
        height: 100px;
    }
    table{
        border-collapse: collapse;
    }
    table,tr,td{
        border:1px solid black;
    }
</style>
</html>
