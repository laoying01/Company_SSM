<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 21:56
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
<div style="background: azure">
    <table border="1px"  align="center" cellpadding="0px" cellspacing="0px">
        <c:forEach items="${sessionScope.o_emp}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>姓名</td>
                    <td>部门ID</td>
                    <td>职位ID</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>出生日期</td>
                    <td>入职日期</td>
                    <td>电话</td>
                    <td>邮箱</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.emp_name}</td>
                <td>${ud.d_id}</td>
                <td>${ud.p_id}</td>
                <td>${ud.emp_gender}</td>
                <td>${ud.emp_age}</td>
                <td>${ud.emp_birth}</td>
                <td>${ud.emp_entry_time}</td>
                <td>${ud.emp_phone}</td>
                <td>${ud.emp_email}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
