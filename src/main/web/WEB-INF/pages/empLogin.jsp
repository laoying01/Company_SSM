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
</head>
<form action="empLogin" method="post">
    账号：<input type="text" name="u_name"></br>
    密码：<input type="text" name="u_pass"></br>
    <input type="submit"value="登录">
</form>
<body class="lg-bg" style='background: url("//c-m-bucket.zhaopin.cn/c/m/imgs/6bc1c352-2a80-4955-93d4-bf05f5271ad7.png") left top;'>
<div class="big-bg"><img class="img-bg" src="//c-m-bucket.zhaopin.cn/c/m/imgs/c7bdf042-3f71-4b2d-9abb-2c47819e3ee3.jpg">
    <div class="logoinner">
        <a href="http://www.zhaopin.com/">
            <img src="/img/common/logo.jpg">
        </a>
    </div>
    <div class="login-box clearfix">
        <h3 class="login-tit">
            <span class="login-account-c taCur">用户登录</span>
            <span class="safe-login">扫码登录</span>
            <span class="phoneLogoIn">短信登录</span>
        </h3>
        <div class="user-login">
            <form class="inner_form" id="form1" action="javascript: void(0);" method="post" novalidate="novalidate" data-ts="5xGY">
                <input name="bkurl" id="bkurl" type="hidden" value="">
                <div class="form border">
                    <label>用户名</label><input name="loginName" class="ipt" id="loginName" type="text" value="">
                </div>
                <div id="alertMessage_loginName" style="color: red;margin-left: 16px;"></div>
                <div class="form border">
                    <label>密 码</label><input name="password" class="ipt" id="password" type="password" value="">
                </div>
                <div id="alertMessage_password" style="color: red;margin-left: 16px;"><em></em></div>
                <div>
                    <input name="submit" class="login-btn __ga__switchTag_loginBtn_001 " id="submit" onclick="ZP.analysis.init_monitor_analy(this,'switchTag','loginBtn','001');;ZP.analysis.init_monitor_analy(this,'switchTag','loginBtn','001');;ZP.analysis.init_monitor_analy(this,'switchTag','loginBtn','001');ZP.analysis.init_monitor_analy(this,'switchTag','loginBtn','001');" type="button" alt="登录" value="登录">
                </div>
                <div class="login-forget">
                    <p>没有智联账号？<a class="__ga__switchTag_regist_001" onclick="ZP.analysis.init_monitor_analy(this,'switchTag','regist','001');;ZP.analysis.init_monitor_analy(this,'switchTag','regist','001');;ZP.analysis.init_monitor_analy(this,'switchTag','regist','001');ZP.analysis.init_monitor_analy(this,'switchTag','regist','001');"></a>
                        <a id="areg" onclick="recordOutboundLink(this,'newregister','registerbtn_2')" href="/register" data-ts="=P(o}}">立即注册</a></p>
                    <a class="fr" href="/findPassword/email/step1" target="_blank">忘记密码</a>
                </div>
                <div class="otherLogin" style="width: 336px; border-top: 1px dotted #ccc; margin-top: 24px; padding-top: 6px;">
                    <span class="click_sf" style="margin-left: 120px;cursor: pointer;">使用其他方式登录</span>
                    <div class="sf_container" style="padding: 4px 0 0 72px; display: none;">
                        <a class="icon_wx __ga__PCoAuthLogin_wxLogin_001" onclick="ZP.analysis.init_monitor_analy(this,'PCoAuthLogin','wxLogin','001');;ZP.analysis.init_monitor_analy(this,'PCoAuthLogin','wxLogin','001');;thirdLogin('weixin');" href="javascript:void(0)"></a>
                        <a class="icon_qq __ga__PCoAuthLogin_qqLogin_001" onclick="ZP.analysis.init_monitor_analy(this,'PCoAuthLogin','qqLogin','001');;ZP.analysis.init_monitor_analy(this,'PCoAuthLogin','qqLogin','001');;thirdLogin('qq');" href="javascript:void(0)"></a>
                        <a class="icon_xl __ga__PCoAuthLogin_weiboLogin_001" onclick="ZP.analysis.init_monitor_analy(this,'PCoAuthLogin','weiboLogin','001');;ZP.analysis.init_monitor_analy(this,'PCoAuthLogin','weiboLogin','001');;thirdLogin('weibo');" href="javascript:void(0)"></a>
                    </div>
                </div>
            </form>
        </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
