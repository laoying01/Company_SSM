<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/25
  Time: 14:23
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
<div style="background: azure;width: 1300px;height: 400px">
    <table border="1px" width="600px" height="100px" align="center" cellpadding="0px" cellspacing="0px">
        <c:forEach items="${sessionScope.pList}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>职位ID</td>
                    <td>职位名称</td>
                    <td>部门是ID</td>
                    <td>修改</td>
                    <td>删除</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.p_id}</td>
                <td>${ud.p_position}</td>
                <td>${ud.d_id}</td>
                <td>
                    <a href="goUpdatePosition?pId=${ud.p_id}">修改</a>
                </td>
                <td>
                    <a href="deletePosition?pId=${ud.p_id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
