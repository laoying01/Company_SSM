<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/22
  Time: 20:09
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
    <meta name="author" content="order by dede58.com"/>
</head>

<frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="files/top.html" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
    <frameset cols="213,*" frameborder="no" border="0" framespacing="0">
        <frame src="files/left.html" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="files/mainfra.html" name="mainFrame" id="mainFrame" title="mainFrame" />
    </frameset>
</frameset>
<body>
<a href="showInterview">查看应聘申请</a>
<a href="showAdmitVisitor">查看面试通过者</a>
<a href="goAddRecruiting">添加招聘信息</a>
<a>修改招聘信息</a>
</body>
</html>
