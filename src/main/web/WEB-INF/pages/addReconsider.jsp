<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 14:26
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
<form action="addReconsider" method="post">
    员工id：<input type="text" name="emp_id">
    复议原因：<input type="text" name="r_cause">
    时间：<input type="date" name="r_time">
    <input type="submit" value="提交">
</form>
</body>
</html>
