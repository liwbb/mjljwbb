<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">图书管理</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li id=home><a href="home">主页</a></li>
					<li id=cardcontrol><a href="cardcontrol">会员管理</a></li>
					<li id=bookControls><a href="bookControls">图书管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">${sessionScope.name	} <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">修改密码</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="userExit">安全退出</a></li>
					</ul></li>
				<li><a href="#">在线人数:${applicationScope.count}</a></li>
			</ul>
				
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
<div class="container">

	<div class="starter-template">
	