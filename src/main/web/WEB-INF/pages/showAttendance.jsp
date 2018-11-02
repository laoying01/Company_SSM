<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 22:47
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
        <c:forEach items="${sessionScope.attendances}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>上班打卡</td>
                    <td>下班打卡</td>
                    <td>日期</td>
                    <td>员工id</td>
                    <td>状态</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.a_id}</td>
                <td>${ud.a_up_work}</td>
                <td>${ud.a_down_work}</td>
                <td>${ud.a_date}</td>
                <td>${ud.emp_id}</td>
                <td>${ud.a_state}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
