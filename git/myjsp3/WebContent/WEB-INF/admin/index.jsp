
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading, .form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>


<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">


<link href="signin.css" rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>


</head>

<body style="background-color: rgb(204, 232, 207);">


	<div class="container">
	<c:if test="${'404' == param.id }">
	<div class="alert alert-warning alert-dismissible fade in"
			role="alert">用户名或密码错误！</div>
	
	</c:if>

		

		<form class="form-signin" method="post" action="/myjsp3/login">
			<h2 class="form-signin-heading">图书管理系统登陆</h2>
			<label for="inputEmail" class="sr-only">账号</label> <input type="text"
				id="inputEmail" name="name" class="form-control" placeholder="请输入账号"
				required="" autofocus=""> <label for="inputPassword"
				class="sr-only">密码</label> <input type="password" id="inputPassword"
				name="pwd" class="form-control" placeholder="请输入密码" required="">
			<div class="checkbox">
				<label> <input value="yes" name="remeberme" type="checkbox"
					value="remember-me"> 7天内自动登录
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
		</form>


	</div>
	<!-- /container -->


	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>