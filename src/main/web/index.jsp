<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
      #body{
          width:100%;
          height:100%;
          background:url("images/abcd.jpg") no-repeat;
          background-size: 100%;
      }
    </style>
</head>
<body id="body">
<table style="margin-left: 900px">
    <tr>
        <td width="100px">
            <c:choose>
                <c:when test="${sessionScope.user!=null}">
                    <button>
                        <a href="goVisitor">游客主页</a>
                    </button>
                </c:when>
                <c:otherwise>
                <button>
                    <a href="goLogin">游客主页</a>
                </button>
                </c:otherwise>
            </c:choose>


        </td>
        <td width="100px">
            <button>

            <a href="goLogin">游客登录</a>
            </button>
        </td>
        <td width="100px">
            <button>

            <a href="goEmpLogin">员工登录</a>
            </button>
        </td>
        <td width="100px">
            <button>

            <a href="goRegister">【注册】</a>
            </button>
        </td>
        <td width="100px">
            <button>

            <a href="goRecruiting">招聘信息</a>
            </button>
        </td>
    </tr>
</table>
<%--<div class="sheader">
    <ul id="wtdaohang">
        <li class="wt_nav_bg"><a &lt;%&ndash;href=""&ndash;%&gt;>【登录】</a>
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
<a href="asdf">跳</a>--%>
</body>

</html>
