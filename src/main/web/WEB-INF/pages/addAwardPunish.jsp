<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/31
  Time: 10:24
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
<form action="addAwardPunish" method="post">
    员工id：<input type="number" name="emp_id">
    奖惩原因：<input type="text" name="ap_cause">
    时间：<input type="text" name="ap_time">
    金额：<input type="number" name="ap_salary">
    <input type="submit" value="提交">
</form>
</body>
</html>
