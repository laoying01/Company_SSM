<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 21:20
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
<form action="updateEmployee" method="post">
    电话：<input type="text" name="emp_phone" value="${sessionScope.employee.emp_phone}">
    邮箱：<input type="text" name="emp_email" value="${sessionScope.employee.emp_email}">
    密码：<input type="text" name="emp_pass" value="${sessionScope.employee.emp_pass}">
    <input type="submit" value="提交">
</form>
</body>
</html>
