﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html class="login-alone">
    <head>
    <base href="<%=basePath%>">
        <title>吉林省低保核对数据导出平台</title>
		<meta name="keywords" content="吉林省低保核对数据导出平台" />
		<meta name="description" content="吉林省低保核对数据导出平台" />
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <link rel="shortcut icon" type="image/x-icon" href="res/homepage/favicon.ico?v=3.9" />
        <link href="res/ui/css/screen.css?v=3.9" media="screen, projection" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" type="text/css" href="res/ui/css/base.css?v=3.9">
        <link rel="stylesheet" type="text/css" href="res/passport/css/login.css?v=3.9">
        <!--[if lt IE 9]>
        <script>
        window.location="support.jsp";
        </script>
        <![endif]-->
    </head>
    <body>
        <div class="logina-logo" style="height: 55px">
		<h1>吉林省低保核对数据导出平台</h1>
           <!-- <a href="">
                <img src="res/passport/images/toplogo.png?v=3.9" height="60" alt="">
            </a> -->
        </div>
        <div class="logina-main main clearfix">
            <div class="tab-con">
                <form id="form-login" method="post" action="${pageContext.request.contextPath}/Login">
                    <div id='login-error' class="error-tip"></div>
                    <table border="0" cellspacing="0" cellpadding="0">
                        <tbody>
                            <tr>
                                <th>账户</th>
                                <td width="245">
                                    <input id="email" type="text" name="username" placeholder="请输入城市或农村用户名" autocomplete="off" value=""></td>
                                <td>
                                </td>
                            </tr>
                            <tr>
                                <th>密码</th>
                                <td width="245">
                                    <input id="password" type="password" name="password" placeholder="请输入密码" autocomplete="off">
                                </td>
                                <td>
                                </td>
                            </tr>
                            <!-- <tr id="tr-vcode" style="display:none;" >
                                <th>验证码</th>
                                <td width="245">
                                    <div class="valid">
                                        <input type="text" name="vcode"><img class="vcode" src="passport/vcode?_=1411476793" width="85" height="35" alt="">
                                    </div>
                                </td>
                                <td>
                                </td>
                            </tr>
                            <tr class="find">
                                <th></th>
                                <td>
                                    <div>
                                        <label class="checkbox" for="chk11"><input style="height: auto;" id="chk11" type="checkbox" name="remember_me" >记住我</label>
                                        <a href="passport/forget-pwd">忘记密码？</a>
                                    </div>
                                </td>
                                <td></td>
                            </tr>-->
                            <tr>
                                <th></th>
                                <td width="245"><input class="confirm" type="submit" value="登  录"></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                    <input type="hidden" name="refer" value="site/">
                </form>
            </div>
            <div class="reg">
                <!-- <p>还没有账号？<br>赶快免费注册一个吧！</p>
                <a class="reg-btn" href="#">立即免费注册</a>-->
				<p align="center">
				<a class="reg-btn" href="soft/360cse.zip">下载360极速浏览器</a></p>
				<p align="center">
				<a class="reg-btn" href="http://10.3.1.30:8080/default/">核对平台网址</a></p>
            </div>
        </div>
        <div id="footer">
            <div class="copyright">吉林省社会救助局</div>
        </div>
        <script src="res/skin/js/lib/jquery-2.0.3.min.js?v=3.9"></script>
        <script src="res/skin/js/ui.common.js?v=3.9"></script>
        <script src="res/passport/js/login.js?v=3.9"></script>       
    </body>
</html>
