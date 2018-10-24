<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/19
  Time: 13:21
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
    <link href="css/main.css" rel="stylesheet" type="text/css" />
</head>

<body class="lg-bg" style='background: url("//c-m-bucket.zhaopin.cn/c/m/imgs/6bc1c352-2a80-4955-93d4-bf05f5271ad7.png") left top;'>
<div class="login">
    <div class="box png">
        <div class="logo png"></div>
        <div class="input">
            <div class="log">
                <form action="empLogin" method="post">
                <div class="name">
                    <label>用户名</label><input type="text" class="text" id="value_1" placeholder="用户名" name="u_name" tabindex="1">
                </div>
                <div class="pwd">
                    <label>密　码</label><input type="password" class="text" id="value_2" placeholder="密码" name="u_pass" tabindex="2">
                    <input type="button" class="submit" tabindex="3" value="登录">
                    <div class="check"></div>
                </div>
                </form>
                <div class="tip"></div>
            </div>
        </div>
    </div>
    <div class="air-balloon ab-1 png"></div>
    <div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript" src="js/jQuery.js"></script>
<script type="text/javascript" src="js/fun.base.js"></script>
<script type="text/javascript" src="js/script.js"></script>

</body>
</html>
