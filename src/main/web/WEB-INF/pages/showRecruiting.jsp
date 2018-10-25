<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/25
  Time: 10:53
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
        <c:forEach items="${sessionScope.rList}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>薪水</td>
                    <td>简介</td>
                    <td>职位ID</td>
                    <td>发布时间</td>
                    <td>招聘人数</td>
                    <td>学历</td>
                    <td>修改</td>
                    <td>删除</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.rec_id}</td>
                <td>${ud.rec_salary}</td>
                <td>${ud.rec_position_statement}</td>
                <td>${ud.p_id}</td>
                <td>${ud.rec_time}</td>
                <td>${ud.rec_people_count}</td>
                <td>${ud.rec_education}</td>
                <td>
                    <a href="goUpdateRecruiting?resId=${ud.rec_id}">修改</a>
                </td>
                <td>
                    <a href="selectRecruiting?resId=${ud.rec_id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
