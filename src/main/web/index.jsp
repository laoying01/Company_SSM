<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/19
  Time: 10:02
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
<div class="sheader">
    <ul id="wtdaohang">
        <li class="wt_nav_bg"><a <%--href=""--%>>【登录】</a>
            <ul>
                <li><a href="goLogin">游客登录</a></li>
                <li><a href="goEmpLogin">员工登录</a></li>
            </ul>
        </li>
        <li class="wt_nav_bg"><a href="goRegister">【注册】</a>

        </li>
    </ul>
</div>
<a href="goRecruiting">招聘信息</a>
<a href="asdf">跳</a>
</body>

</html>
