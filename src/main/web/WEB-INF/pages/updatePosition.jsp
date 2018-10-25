<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/25
  Time: 14:30
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
<form action="updatePosition" method="post">
    职位ID：<input type="text" name="p_id" value="${sessionScope.po.p_id}" readonly/>
    职位名称：<input type="text" name=p_position value="${sessionScope.po.p_position}"/>
    部门ID：<input type="text" name="d_id" value="${sessionScope.po.d_id}"readonly/>
    <input type="submit" value="提交">
</form>
</body>
</html>
