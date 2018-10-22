<%--
  Created by IntelliJ IDEA.
  User: laoying
  Date: 2018/10/20
  Time: 9:12
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
<form action="writeResume" method="post">
<table width="700" height="542" border="1" background="images/resume.jpg" align="center">
    <caption><h3>个人简历</h3></caption>
    <tr>
        <td width="92">姓名:</td>
        <td width="92"><input type="text" style="width:92px" name="res_name"></td>
        <td width="120">出生日期:</td>
        <td width="113"><input type="text" style="width:200px" name="res_birth"></td>
        <td width="91">性别:</td>
        <td width="48"><input type="text" style="width:48px" name="res_gender"></td>
    </tr>
    <tr>
        <td>学历:</td>
        <td><input type="text" style="width:92px" name="res_education"></td>
        <td>身份证:</td>
        <td><input type="text" style="width:200px" name="res_idCard"></td>
        <td>年龄:</td>
        <td><input type="text" style="width:48px" name="res_age"></td>
    </tr>
    <tr>
        <td>求职意向:</td>
        <td width="113"><input type="text" style="width:92px" name="res_job_intention"></td>
        <td>专业及院校:</td>
        <td colspan="3"><input type="text" style="width:300px" name="res_major"></td>
    </tr>
    <tr>
        <td>电话:</td>
        <td width="113"><input type="text" style="width:92px" name="res_phone"></td>
        <td>邮箱:</td>
        <td ><input type="text" style="width:200px" name="res_email"></td>
        <td width="91">期望薪资:</td>
        <td width="48"><input type="text" style="width:48px" name="res_hopeSalary"></td>
    </tr>
    <tr>
        <td height="24" colspan="2">住址:</td>
        <td colspan="4"><input type="text" style="width:320px" name="res_address"></td>
    </tr>

    <tr>
        <td colspan="7" align="center"><b>教育经历</b></td>
    </tr>
    <tr align="center">
        <td colspan="7"><textarea rows="15" cols="70" name="res_education_background">
		小学............<br/>
           初中............<br/>
           高中............<br/>
           大学............<br/>
	   </textarea></td>

    </tr>
    <tr>
        <td colspan="7" align="center"><b>项目经验</b></td>
    </tr>
    <tr align="center">
        <td colspan="7"><textarea rows="15" cols="70" name="res_work_experience">
		小学............<br/>
           初中............<br/>
           高中............<br/>
           大学............<br/>
	   </textarea></td>
    </tr>
    <tr>
        <td colspan="7" align="center"><b>自我评价</b></td>
    </tr>
    <tr align="center">
        <td colspan="7"><textarea rows="15" cols="70" name="res_about_me">
		小学............<br/>
           初中............<br/>
           高中............<br/>
           大学............<br/>
	   </textarea></td>
    </tr>
</table>
    <input type="submit" value="提交">
</form>
</body>
</html>
