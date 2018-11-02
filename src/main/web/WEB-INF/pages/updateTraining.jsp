<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/30
  Time: 15:32
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
<form action="updateTraining">
    培训编号：<input type="text" name="t_id" value="${requestScope.training.t_id}" readonly>
    培训主题：<input type="text" name="t_theme" value="${requestScope.training.t_theme}">
    培训内容：<textarea name="t_content" placeholder="${requestScope.training.t_content}">${requestScope.training.t_content}
    </textarea>
    培训时间：<input type="text" name="t_start_time" value="${requestScope.training.t_start_time}">
    结束时间：<input type="text" name="t_end_time" value="${requestScope.training.t_end_time}">
    培训地点：<input type="text" name="t_address" value="${requestScope.training.t_address}">
    <input type="hidden" name="emp_id" value="${requestScope.training.emp_id}">
    <input type="submit" value="提交">
</form>
</body>
</html>
