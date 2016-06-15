<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.it.entity.Card"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}

tr:nth-child(6n-1) {
	background-color: gray;
}

tr:nth-child(6n-2) {
	background-color: yellow;
}

tr:nth-child(6n-3) {
	background-color: green;
}

tr:nth-child(6n-4) {
	background-color: white;
}

tr:nth-child(6n-5) {
	background-color: blue;
}

tr:nth-child(6n-6) {
	background-color: violet;
}

.headercss {
	background-color: violet;
}

.btn-success {
	float: right;
}

.btn-cy {
	float: left;
	margin-top: -25px
}

.navbar-form {
	
}
td{
text-align: left;

}
</style>
<meta charset="utf-8">


<title>图书管理系统</title>

<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">





</head>

<body>

	<%@ include file="tfbody.jsp"%>
	
	
	<c:if test="${'404'==param.id }"><div class="alert alert-warning alert-dismissible fade in"
			role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button><strong>删除失败！</strong>
		</div></c:if>
	

	<div class="bs-example" data-example-id="contextual-table">
		<div class="btn-cy btn-success">
			一共 &nbsp; &nbsp;&nbsp; <a class="btn-danger"> &nbsp; &nbsp; 
				${requestScope.list.size() }&nbsp; &nbsp;
			</a>&nbsp;&nbsp;&nbsp;个会员
		</div>
		<form action="/myjsp3/cardxc" method="get"
			style="margin-left: -20px;" class="navbar-form navbar-left"
			role="search">
			<div class="form-group">
				<input type="text" name="wd" class="form-control" placeholder="查询">
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form>
		<table class="table">

			<button type="button" class="btn btn-success">添加新会员</button>
			<thead>
				<tr class="info">
					<th>标号</th>
					<th>编号</th>
					<th>姓名</th>
					<th>电话</th>
					<th>操作</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="card" items="${requestScope.list }">

				<tr>
					<th scope="row">${card.id }</th>
					<td>${card.code }</td>
					<td>${card.name }</td>
					<td>${card.tel }</td>
				
					<td>
						<button data="${card.id }" type="button"
							class="btn btn-danger btn-xs">删除</button>
						<button data="${card.id }" type="button"
							class="btn btn-warning btn-xs">修改</button>
					</td>
				</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	</div>

	</div>
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="/myjsp3/js/jquery.validate.min.js"></script>
	<script>
	$("ul.nav>li:nth-child(2)").addClass("active");
	
	$(function() {
		$("td>button.btn-warning").click(function() {

			var a = $(this).attr("data");

			// 					location.href="/myjsp2/carddel.jsp?id="+a;
			location.href = "/myjsp3/cardupdate?id=" + a;

		})
		$("td>button.btn-danger").click(function() {
			if (confirm("确认删除吗")) {
				var a = $(this).attr("data");

				// 					location.href="/myjsp2/carddel.jsp?id="+a;
				location.href = "/myjsp3/carddel?id=" + a;

			}

		})
		$(".btn-success").click(function() {
			if (confirm("确认添加图书吗")) {

				// 					location.href="/myjsp2/carddel.jsp?id="+a;
				location.href = "/myjsp3/cardaddstz";

			}

		})

	});
	
	
	</script>


</body>
</html>
