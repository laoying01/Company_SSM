<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/30
  Time: 14:01
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
<form action="addTraining" method="post">
    <div style="background: azure;width: 1300px;height: 400px">
        <table border="1px" width="600px" height="100px" align="center" cellpadding="0px" cellspacing="0px">
            <c:forEach items="${sessionScope.t_e}" var="ud" varStatus="a">
                <c:if test="${a.count==1}">
                    <tr>
                        <td><input type="checkbox" id="allcheck" onclick="demo()">全选</td>
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
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <input type="checkbox" name="change" value="${ud.emp_id}">
                    </td>
                    <td>${ud.emp_id}</td>
                    <td>${ud.emp_name}</td>
                    <td>${ud.emp_account_number}</td>
                    <td>${ud.emp_pass}</td>
                    <td>${ud.d_id}</td>
                    <td>${ud.p_id}</td>
                    <td>${ud.emp_gender}</td>
                    <td>${ud.emp_age}</td>
                    <td>${ud.emp_birth}</td>
                    <td>${ud.emp_entry_time}</td>
                    <td>${ud.emp_salary}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    培训主题：<input type="text" name="t_theme"><br/>
    培训内容：<textarea name="t_content">
    </textarea><br/>
    培训时间：<input type="date" name="t_start_time"><input type="time" name="t1"><br/>
    结束时间：<input type="date" name="t_end_time"><input type="time" name="t2"><br/>
    培训地点：<input type="text" name="t_address"><br/>
    <input type="submit" value="提交"><br/>
</form>
</body>
<script>
    function demo(){
        var allcheck=document.getElementById("allcheck");
        var choice=document.getElementsByName("change");
        for(var i=0;i<choice.length;i++){
            choice[i].checked=allcheck.checked;
        }
    }
</script>
</html>
