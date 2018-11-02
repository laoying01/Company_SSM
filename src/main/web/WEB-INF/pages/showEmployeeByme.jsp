<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 20:23
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
                <tr>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>账号</td>
                    <td>密码</td>
                    <td>部门ID</td>
                    <td>职位ID</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>出生日期</td>
                    <td>入职日期</td>
                    <td>薪水</td>
                    <td>入职状态</td>
                    <td>离职原因</td>
                    <td>电话</td>
                    <td>邮箱</td>
                </tr>
            <tr>
                <td>${sessionScope.employee.emp_id}</td>
                <td>${sessionScope.employee.emp_name}</td>
                <td>${sessionScope.employee.emp_account_number}</td>
                <td>${sessionScope.employee.emp_pass}</td>
                <td>${sessionScope.employee.d_id}</td>
                <td>${sessionScope.employee.p_id}</td>
                <td>${sessionScope.employee.emp_gender}</td>
                <td>${sessionScope.employee.emp_age}</td>
                <td>${sessionScope.employee.emp_birth}</td>
                <td>${sessionScope.employee.emp_entry_time}</td>
                <td>${sessionScope.employee.emp_salary}</td>
                <td>${sessionScope.employee.emp_state}</td>
                <td>${sessionScope.employee.emp_dimission_cause}</td>
                <td>${sessionScope.employee.emp_phone}</td>
                <td>${sessionScope.employee.emp_email}</td>
                <td>
                    <form action="goUpdateEmployee">
                        <input type="hidden" name="employeeId" value="${ud.emp_id}">
                        <input type="submit" value="修改">
                    </form>

                </td>
            </tr>
    </table>
</div>
</body>
</html>
