<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/26
  Time: 20:43
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
<p>${sessionScope.employee.emp_name}</p>
<a href="dimission?empId="${sessionScope.employee.emp_id}">离职</a>
</body>
</html>
