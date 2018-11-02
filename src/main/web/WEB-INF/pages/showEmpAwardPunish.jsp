<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 21:49
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
        <c:forEach items="${sessionScope.emp_ap}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>金额</td>
                    <td>时间</td>
                    <td>原因</td>
                    <td>员工id</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.ap_id}</td>
                <td>${ud.ap_salary}</td>
                <td>${ud.ap_time}</td>
                <td>${ud.ap_cause}</td>
                <td>${ud.emp_id}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
