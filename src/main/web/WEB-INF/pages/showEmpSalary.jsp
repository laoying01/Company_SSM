<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 22:09
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
        <c:forEach items="${sessionScope.emp_salary}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>薪水</td>
                    <td>日期</td>
                    <td>员工ID</td>
                    <td>绩效</td>
                    <td>加班</td>
                    <td>社保</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.s_id}</td>
                <td>${ud.s_salary}</td>
                <td>${ud.s_date}</td>
                <td>${ud.emp_id}</td>
                <td>${ud.s_performance}</td>
                <td>${ud.s_work_overtime}</td>
                <td>${ud.s_social_security}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
