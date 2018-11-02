<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 18:47
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
<button>
    <a href="addAttendance?empId=${sessionScope.employee.emp_id}">
        打卡
    </a>
</button>
<p>${requestScope.msg}</p>
</body>
</html>
