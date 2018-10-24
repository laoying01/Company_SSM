<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/22
  Time: 22:03
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
        <c:forEach items="${sessionScope.admitVisitor}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>职位</td>
                    <td>简历</td>
                    <td>查看</td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.i_id}</td>
                <td>${sessionScope.i_position[a.count-1].p_position}</td>
                <td>
                        ${ud.res_id}
                </td>
                <td>
                    <a href="admitVisitor?admit_visitor_i_id=${ud.i_id}">录用</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
