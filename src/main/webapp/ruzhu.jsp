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
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script>
        $(function () {
            var s=$("#chaun").text()
            $.ajax({
                url:"/ssm/RoomFindAndState",
                type:"post",
                data:{"state":"空闲"},
                dataType:"json",
                success:function (data) {
                    for (var o in data){
                        if (data[o].rid==s){
                            var option="<option selected='selected' value="+data[o].rid+">"+data[o].rid+"</option>";
                        }else{
                            var option="<option value="+data[o].rid+">"+data[o].rid+"</option>";
                        }

                        $("#roomId").append(option)
                    }

                }
            })
        })

    </script>
</head>
<body>
        <span style="display: none" id="chaun"><%=request.getParameter("rid")%></span>
        <form action="ruzhu" method="post">
            房间号：<select id="roomId" name="rid">
                        <option>----请选择----</option>
                   </select><br>
            姓名：<input type="text" name="uName"><br>
            身份证：<input type="text" name="IdCard"><br>
            入住人数：<input type="text" name="number"><br>
            入住天数：<input type="text" name="day">

            <input type="submit" value="登记入住">

        </form>
</body>
</html>
