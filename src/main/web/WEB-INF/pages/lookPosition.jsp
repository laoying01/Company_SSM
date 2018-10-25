<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/25
  Time: 16:00
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
    <script src="js/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            $("#s1").change(function () {
                $.ajax({
                    type:"post",
                    url:"selectEmp",
                    data:{"empId":$(this).val()},
                    success:function (obj) {
                        $("#s2 option").remove();
                        $("#s2").append("<option value='0'>请选择</option>");
                        for (var i=0;i<obj.length;i++){
                            $("#s2").append("<option value="+obj[i].emp_id+">"
                                + obj[i].emp_name + "</option>");
                        }
                    }
                })
            })
        });
    </script>
</head>
<body>
<select name="changeP" id="s1">
    <option value="0">请选择</option>
        <c:forEach items="${sessionScope.pList}" var="p">
            <option value="${p.p_id}">${p.p_position}</option>
        </c:forEach>
</select>
<select name="changeE" id="s2">
    <option value="0">请选择</option>
</select>
</body>
</html>
