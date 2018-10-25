<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/23
  Time: 10:33
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
<form action="addRecruiting" method="post">
    职位:<select name="pid">
        <c:forEach items="${sessionScope.positions}" var="i">
            <option>${i.p_id},${i.p_position}</option>
        </c:forEach>
    </select>
    薪资：<input type="text" name="rec_salary">
    学历：<input type="text" name="rec_education">
    描述：<input type="text" name="rec_position_statement">
    人数：<input type="text" name="rec_people_count">
    <input type="submit" value="提交">
</form>
</body>
</html>
