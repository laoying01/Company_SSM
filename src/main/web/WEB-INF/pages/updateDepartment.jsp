<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/24
  Time: 14:48
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
        <c:forEach items="${sessionScope.departmentList}" var="ud" varStatus="a">
            <c:if test="${a.count==1}">
                <tr>
                    <td>编号</td>
                    <td>部门</td>
                    <td>创建时间</td>
                    <td></td>
                    <td></td>
                </tr>
            </c:if>
            <tr>
                <td>${ud.d_id}</td>
                <td>${ud.d_department}</td>
                <td>
                        ${ud.d_create_time}
                </td>
                <td>
                    <a href="toUpdateDepartment?d_id=${ud.d_id}" onclick="x()">修改</a>
                </td>
                <td>
                    <a href="deleteDepart?d_id=${ud.d_id}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="d1">
    <form>
        修改部门<input type="text" name="d_depart" value="${requestScope.depart.d_department}">
        <input type="hidden" name="d_id" value="${requestScope.depart.d_id}">
        <input type="submit" value="提交" onclick="x()">
    </form>
</div>
</body>
<script>
    function x() {
       var d =document.getElementById("d1");
       if (d.style.display=="none"){
           d.style.display="block";
       }else {
           d.style.display="none";
       }
    }
</script>
</html>
