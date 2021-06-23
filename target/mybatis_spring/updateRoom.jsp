<%--
  Created by IntelliJ IDEA.
  User: CHX1057592614
  Date: 2020/11/11
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            var rid=$(".rid").text();
            $.ajax({
                url:"findRoomById",
                type:"post",
                data:{"rid":rid},
                dataType:"json",
                success:function (data) {
                    sessionStorage.setItem("roomType",JSON.stringify(data.roomType));
                    $("[name=bedNum]").val(data.bedNum);
                    $("[name=roomImg]").attr('src',data.img)
                }
            });
            //查询所有房间类型
            $.ajax({
                url:"findRoomType",
                type:"post",
                dataType:"json",
                success:function (data) {
                    var roomT=JSON.parse(sessionStorage.getItem("roomType"))
                    for (var o in data){
                        if (roomT==data[o].roomType){
                            var option="<option selected=selected value='"+data[o].roomType+"'>"+data[o].name+"</option>"
                        }else {
                            var option="<option value='"+data[o].roomType+"'>"+data[o].name+"</option>"
                        }
                        $("[name=roomType]").append(option);
                    }
                }
            })
        })
    </script>
</head>
<body>
    <span class="rid" style="display: none" name="oldRid"><%=request.getParameter("rid")%></span>
    <span class="roomT"></span>
    <form action="updateRoom" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>房照</td>
                <td>房间编号</td>
                <td>房间类型</td>
                <td>床位</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <input type="hidden" name="oldRid" value="<%=request.getParameter("rid")%>">
                <td><img class="roomImg" name="roomImg" src="#"/></td>
                <td><input type="text" name="rid" value="<%=request.getParameter("rid")%>"/></td>
                <td><select name="roomType">
                    <option>---请选择---</option>
                </select></td>
                <td><input type="text" name="bedNum"/></td>
                <td>重新上传图片：<input type="file" name="roomImg"/></td>
                <td><input type="submit" value="修改"/></td>
            </tr>
        </table>
    </form>
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
