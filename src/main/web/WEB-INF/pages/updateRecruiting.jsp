<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/25
  Time: 10:13
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
<form action="updateRecruiting" method="post">
    编号：<input type="text" name="rec_id" value="${sessionScope.rec.rec_id}" readonly/>
    职位ID：<input type="text" name=p_id value="${sessionScope.rec.p_id}"readonly/>
    描述：<input type="text" name="rec_position_statement" value="${sessionScope.rec.rec_position_statement}"readonly/>
    发布时间：<input type="text" name="rec_time" value="${sessionScope.rec.rec_time}"readonly/>
    薪资：<input type="text" name="rec_salary" value="${sessionScope.rec.rec_salary}">
    学历：<input type="text" name="rec_education" value="${sessionScope.rec.rec_education}">
    人数：<input type="text" name="rec_people_count" value="${sessionScope.rec.rec_people_count}">
    <input type="submit" value="提交">
</form>
</body>
</html>
