<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <html class="bg-img"> -->
<!DOCTYPE HTML>
<html>
<head>
<title>后台登录</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<!-- Custom Theme files -->
<link href="${contextPath}/static/css/newlogin/css/style.css"
	rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="后台登录" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="/managersys/static/js/html5shiv.js"></script>
    <script src="/managersys/static/js/respond.min.js"></script>
    <![endif]-->
<!-- jQuery 2.0.2 -->
<script src="${contextPath}/static/js/login/jquery.min.js"></script>
<script src="${contextPath}/static/js/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="${contextPath}/static/js/messages_zh.min.js"
	type="text/javascript"></script>

<!-- validate 插件错误提示颜色 -->
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>

	<div class="login-form">
		<div class="top-login">
			<span><img
				src="${contextPath}/static/css/newlogin/images/group.png" alt="" /></span>
		</div>
		<h1>用户登录</h1>
		<div class="login-top">
			<form id="loginForm" name="login" action="login" method="POST"
				onsubmit="return loginSubmit();">
				<div class="login-ic">
					<i></i> <input type="text" value="用户名" id="username"
						name="username" onFocus="this.value = '';clearloginErrorMsg();"
						onBlur="if (this.value == '') {this.value = '用户名';}"/>
					<div class="clear"></div>
				</div>
				<div class="login-ic">
					<i class="icon"></i> <input type="password" id="password"
						name="password" value="密码" onFocus="this.value = '';"
						onBlur="if (this.value == '') {this.value = '密码';}" />
					<c:if test="${loginError !=null }">
						<label id="loginError" style="color: red"> ${loginError} </label>
					</c:if>
					<div class="clear"></div>
				</div>


				<div class="log-bwn">
					<input type="submit" value="登录"> <input type="button"
						value="忘记密码" onclick="forgetPwd();">
				</div>
			</form>
		</div>
		<p class="copy">
			©&nbsp;2017&nbsp;<a href="javascript:void(0)"
				style="text-decoration: none">贵州威宁经济开发区物业管理有限公司劳务派遣信息管理系统</a> <br />
			<span style="font-size: 13px;">温馨提示：为保证您的正常使用，推荐使用360、谷歌、火狐浏览器，禁止使用IE浏览器。谢谢!</span>
		</p>
	</div>
</body>
<script type="text/javascript">
	$().ready(function() {
		$("#loginForm").validate({
			rules : {
				username : {
					required : true,
					minlength : 4
				},
				password : {
					required : true,
					minlength : 6
				}
			},
			messages : {
				username : {
					required : "请输入用户名",
					minlength : "至少4个字符"
				},
				password : {
					required : "请输入密码",
					minlength : "至少6个字符"
				}
			}
		})
	});

	//登录表单提交
	function loginSubmit() {
		return $("#loginForm").validate().form();
	}

	//忘记密码
	function forgetPwd() {
		alert("提示：请使用管理员账号登录，然后修改用户密码！")
	}
	
	function clearloginErrorMsg(){
		var loginError = document.getElementById("loginError");
		if(loginError != null){
			loginError.innerHTML = "";
		}
	}
</script>
</html>