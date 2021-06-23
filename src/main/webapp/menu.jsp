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
</head>
<script>
    function getObject(objectId) {
        if(document.getElementById && document.getElementById(objectId)) {
            // W3C DOM
            return document.getElementById(objectId);
        }
        else if (document.all && document.all(objectId)) {
            // MSIE 4 DOM
            return document.all(objectId);
        }
        else if (document.layers && document.layers[objectId]) {
            // NN 4 DOM.. note: this won't find nested layers
            return document.layers[objectId];
        }
        else {
            return false;
        }
    }
    function showHide(objname){
        var obj = getObject(objname);
        if(obj.style.display == "none"){
            obj.style.display = "block";
        }else{
            obj.style.display = "none";
        }
    }
</script>
<body>
<div>

    <dl>

        <dt><a href="###" onclick="showHide('items1');" target="_self">客房管理</a></dt>
        <dd id="items1" style="display:none;">
            <ul>
                <li><a href='kaifang.jsp' target='main'>开房记录</a></li>
                <li><a href='ruzhu.jsp' target='main'>办理入住</a></li>
                <li><a href='chaxun.jsp' target='main'>客房查询</a></li>
                <li><a href='roomType.jsp' target='main'>房间类型</a></li>

            </ul>
        </dd>
    </dl>
</div>

</body>
</html>
