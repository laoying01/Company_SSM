<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/19
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    账号：<input type="text" name="u_name"></br>
    密码：<input type="text" name="u_pass"></br>
    确认密码：<input type="text"></br>
    <input type="submit" value="提交">
</form>
</body>
</html>
