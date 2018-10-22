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
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>通信职位库 - 通信企业招聘|网优工程师招聘|通信工程师招聘 - 通信人才网</title>
    <meta name="description" content="通信高薪职位，汇集国内上万家知名通信企业，找通信工作，就在通信人才网。">
    <meta name="keywords" content="通信人才网，通信工程师,通信人才网，人才,通信，程序员、硬件工程师、系统工程师、测试工程师、数据库工程师、系统集成工程师、前端开发工程师、高级软件工程师、嵌入式软件工程师、java软件工程师">
    <link href="https://www.telecomhr.com/css/common.css" rel="stylesheet" type="text/css">
    <script src="https://www.telecomhr.com/js/jquery.min.js" type="text/javascript"></script>
    <script src="https://www.telecomhr.com/js/jquery.alertwindow.js" type="text/javascript"></script>
    <script src="https://www.telecomhr.com/js/service.js" type="text/javascript"></script>
    <script src="http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=427760"></script>
</head>
<body>
<div class="head">
    <div class="sheader">
        <ul id="wtdaohang">
            <li><a href="goVisitor">游客主页</a></li>
            <li class="wt_nav_bg"><a <%--href=""--%>>【登录】</a>
                <ul>
                    <li><a href="login">游客登录</a></li>
                    <li><a href="empLogin">员工登录</a></li>
                </ul>
            </li>
            <li class="wt_nav_bg"><a href="goRegister">【注册】</a>

            </li>
            <li><a href="https://www.telecomhr.com/help">帮助</a></li>
        </ul>
    </div>
</div>
<div class="zwlb_con">
    <div class="zwlb_zj">
        <div style="clear:both;"></div>
        <div class="zwlb_zj_right">
            <form id="formsearch" action="index.php" method="method">
                <legend><b><font class="f14">分类浏览职位</font></b>&nbsp;<a class="f12" style="COLOR: #666" href="#"></a></legend>
                <select name="bc" class="basic" id="bc" style="width:185px;" size="1">
                    <option selected="selected" value="">--请选择职位类别(大类)--</option>

                    <option value="2083">通信经营管理类</option>

                    <option value="2084">通信销售/市场类 </option>

                    <option value="2102">通信网络优化类(RF)</option>

                    <option value="2085">核心网技术类</option>

                    <option value="2099">通信开发与研发类</option>

                    <option value="2105">通信工程与勘测设计类</option>

                    <option value="2103">光通信和传输电源类</option>

                    <option value="2104">数据业务和支撑网类</option>

                    <option value="2098">手机APP应用开发类</option>

                    <option value="2100">手机研发和制造类</option>

                    <option value="2096">行政/财务/人事/客服类 </option>

                    <option value="1036">其他类</option>


                </select>
                <select name="sc" class="basic" id="sc" style="width:185px;">
                    <option selected="selected" value="">--请选择职位类别(小类)--</option>

                </select>
                <span class="sr">输入关键字 :    <input name="keyword" style="width:210px; height:27px;" type="text" size="15" maxlength="14" placeholder="输入关键字搜索职位或企业" value=""></span>
                <input class="tyan4 tyan tyan_floating" style="cursor:pointer;" type="submit" value="浏览职位">
            </form>
        </div>
    </div>
    <div class="zwlb_left">

        <table width="800" class="joblist">
            <tbody><tr>
                <th width="30%">招聘职位</th>
                <th width="31%">企业名称</th>
                <th width="8%">招聘人数</th>
                <th width="8%">学历要求</th>
                <th width="8%">工作经验</th>
                <th width="10%">发布日期</th>
            </tr>
<c:forEach items="${sessionScope.recList}" var="i" varStatus="k">
            <tr>
                <td align="center"><c:out value="${sessionScope.positionList[k.count-1].p_position}"></c:out></td>
                <td align="center">上海音达科技实业有限公司

                    <img title="金牌认证企业，请放心投递" src="https://www.telecomhr.com/images/picq_rztg.png">


                </td>
                <td align="center">10人</td>
                <td align="center">大专                           </td>
                <td align="center">

                    2年

                </td>
                <td align="center">${i.rec_time}</td>
            </tr>
            <tr>
                <td align="left" colspan="6">
                    <div style="float:right; width:140px;">
                            <c:choose >
                                <c:when test="${sessionScope.user!=null}">
                                    <a class="btn2 btnsF12" href="goResume?rec_id=${i.rec_id}" target="_blank">应聘</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="btn2 btnsF12" href="goLogin" target="_blank">应聘</a>
                                </c:otherwise>
                            </c:choose>
                    </div>
                    <span style="font-weight:bold;">工作地点</span>：上海                           <br>
                    <span style="font-weight:bold;">薪资待遇</span>：

                    ${i.rec_salary}

                    <br>
                    <span style="font-weight:bold;">职位描述</span>：<br> ${i.rec_position_statement}
                    <br>

                </td>
            </tr>
</c:forEach>
            </tbody></table>
    </div>
</div>

</body>
</html>

