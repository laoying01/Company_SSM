<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/22
  Time: 20:09
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
<a href="showInterview">查看应聘申请</a>
<a href="showAdmitVisitor">查看面试通过者</a>
</body>
</html>