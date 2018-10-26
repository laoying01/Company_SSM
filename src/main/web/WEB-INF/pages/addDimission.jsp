<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/26
  Time: 20:56
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
<form action="dimission">
    离职原因:<textarea name="dimission">

</textarea>
    <input type="submit" value="提交">
</form>

</body>
</html>
