<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/13 0013
  Time: 上午 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="easyuiBasic.jsp"%>
</head>
<body>
<div id="win-1" class="easyui-window" title="登录" style="top:20%;left:20%;width:500px;height:300px;padding: 50px 120px" >
    <form action="${pageContext.request.contextPath}/employee/login" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td>
                    <input type="text" class="easyui-textbox" name="name"/>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input class="easyui-passwordbox" name="password"/>
                </td>
            </tr>
            <tr>

                <td colspan="2">
                    <input type="submit" value="登录" class="easyui-linkbutton" style="width: 100px;height: 50px"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
