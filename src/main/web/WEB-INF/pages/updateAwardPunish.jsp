<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/31
  Time: 11:01
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
<form action="updateAwardPunish" method="post">
    奖惩ID：<input type="text" name="ap_id" value="${requestScope.awardPunish.ap_id}" readonly/>
    金额：<input type="text" name="ap_salary" value="${requestScope.awardPunish.ap_salary}"/>
    时间：<input type="text" name="ap_time" value="${requestScope.awardPunish.ap_time}"/>
    原因：<input type="text" name="ap_cause" value="${requestScope.awardPunish.ap_cause}">
    员工id：<input type="text" name="emp_id" value="${requestScope.awardPunish.emp_id}">
    <input type="submit" value="提交">
</form>
</body>
</html>
