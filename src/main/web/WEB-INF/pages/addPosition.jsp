<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/25
  Time: 14:12
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
<form action="addPosition" method="post">
    职位：<input type="text" name="p_position"><p>${requestScope.msg}</p>
    部门ID：<input type="text" name="d_id">
    <input type="submit" value="提交">
</form>
</body>
</html>
