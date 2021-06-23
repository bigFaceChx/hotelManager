<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/10
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js" type="text/javascript"></script>

    <script>
        $(function () {
            //获取房间
            $.ajax({
                url:"/ssm/RoomFind",
                type:"post",
                dataType:"json",
                success:function (data) {
                    for (var o in data){
                        var tr = $("<tr>"+
                            "<td>"+"<img class='roomImg' src="+data[o].img+">"+"</td>"+
                            "<td>"+data[o].rid+"</td>"+
                            "<td>"+data[o].roomType+"</td>"+
                            "<td>"+data[o].price+"</td>"+
                            "<td>"+data[o].bedNum+"</td>"+
                            "<td>"+data[o].state+"</td>"
                            );
                        if (data[o].state=="正在使用"){
                            tr.append("<td><a class='tuifang' href='tuifang?rid="+data[o].rid+"'>退房</a></td>")
                        }else{
                            tr.append("<td><a class='jinyong' href='ruzhu.jsp?rid="+data[o].rid+"'>办理入住</a></td>")
                        }
                        tr.append("<td><a class='delRoom' href='delRoom?rid="+data[o].rid+"'>删除</a></td>")
                        tr.append("<td><a class='updateRoom' href='updateRoom.jsp?rid="+data[o].rid+"'>修改</a></td>")
                        tr.append("</tr>")
                       /* "<td><a class='tuifang' href='tuifang?rid="+data[o].rid+"'>退房</a></td>"+*/
                        $("#room").append(tr)
                    }
                }
            });
            //获取房间类型
            $.ajax({
                url:"findRoomType",
                type: "post",
                dataType: "json",
                success:function (data) {
                   for (var o in data){
                       var option="<option value='"+data[o].roomType+"'>"+data[o].name+"</option>"
                       $("[name=roomType]").append(option);
                   }
                }
            });
            /*//给删除按钮绑定点击事件
            $("#delRoom").click(function () {
                if (confirm("确认删除该房间吗？")){
                        var href=this.attr("href");
                        alert(href);
                        window.location.href=href;
                }
            })*/
        })
        function addHouse() {
            var display=$("[action=addRoom]").css("display");
            if (display=="none"){
                $("[action=addRoom]").css('display','block');
            }else {
                $("[action=addRoom]").css('display','none');
            }
        }
    </script>
</head>
<body>
<button name="addHouse" onclick="addHouse()">添加房间</button>
<form style="display: none" action="addRoom" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td> 房间号：<input type="text" name="rid"><br></td>
            <td>房间类型：<select name="roomType">
                <option>--请选择--</option>
            </select></td>
            <td>床数：<input type="text" name="bedNum" ><br></td>
            <td>房间照片：<input type="file" name="img"><br></td>
            <td>添加：<input type="submit"><br></td>
        </tr>
    </table>
</form>
    <table id="room">
        <tr>
            <td>房间图片</td>
            <td>房间号</td>
            <td>房间类型</td>
            <td>房间价格</td>
            <td>床的数量</td>
            <td>房间状态</td>
            <td colspan="3">操作</td>
        </tr>
    </table>
</body>
<style type="text/css">
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
    .jinyong{

    }
</style>
</html>
