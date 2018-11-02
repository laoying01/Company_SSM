<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/11/1
  Time: 15:02
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
        <c:forEach items="${sessionScope.reconsiders}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>原因</td>
                    <td>时间</td>
                    <td>员工id</td>
                    <td>无效</td>
                    <td>有效</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.r_id}</td>
                <td>${ud.r_cause}</td>
                <td>${ud.r_time}</td>
                <td>${ud.emp_id}</td>
                <td>
                    <a href="updateReconsider?rId=${ud.r_id}">复议无效</a>
                </td>
                <td>
                    <a href="updateRecon?r_Id=${ud.r_id}">确认有效</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
