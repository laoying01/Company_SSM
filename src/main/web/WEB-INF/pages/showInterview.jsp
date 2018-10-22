<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/22
  Time: 20:24
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
        <c:forEach items="${sessionScope.showInterview}" var="ud" varStatus="a">
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
                    <a href="showResume?resId=${ud.res_id}&interviewId=${ud.i_id}">详情</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
