<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			删除失败！
		</div></c:if>
	
	

	<div class="bs-example" data-example-id="contextual-table">
		<div class="btn-cy btn-success">
			一共 &nbsp; &nbsp;&nbsp; <a class="btn-danger"> &nbsp; &nbsp; 
				${requestScope.list.size() }&nbsp; &nbsp;
			</a>&nbsp;&nbsp;&nbsp;种图书
		</div>
		<form action="/myjsp3/bookcx" method="get"
			style="margin-left: -20px;" class="navbar-form navbar-left"
			role="search">
			<div class="form-group">
				<input type="text" name="wd" class="form-control" placeholder="查询">
			</div>
			<button type="submit" class="btn btn-default">查询</button>
		</form>
		<table class="table">

			<button type="button" class="btn btn-success">添加新书籍</button>
			<thead>
				<tr class="info">
					<th>标号</th>
					<th>编号</th>
					<th>书号</th>
					<th>作者</th>
					<th>出版社</th>
					<th>总数</th>
					<th>剩余数量</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="book" items="${requestScope.list }">
				

				<tr>
					<th scope="row">${book.id}</th>
					<td>${book.code}</td>
					<td>${book.title}</td>
					<td>${book.author}</td>
					<td>${book.publishing}</td>

					<td>${book.total}</td>
					<td>${book.count}</td>
					<td>
						<button data="${book.id}" type="button"
							class="btn btn-danger btn-xs">删除</button>
						<button data="${book.id}" type="button"
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
	$("#bookControls").addClass("active");
	
	$(function() {
		$("td>button.btn-warning").click(function() {

			var a = $(this).attr("data");

			// 					location.href="/myjsp2/carddel.jsp?id="+a;
			location.href = "/myjsp3/bookupdate?id=" + a;

		})
		$("td>button.btn-danger").click(function() {
			if (confirm("确认删除吗")) {
				var a = $(this).attr("data");

				// 					location.href="/myjsp2/carddel.jsp?id="+a;
				location.href = "/myjsp3/bookdel?id=" + a;

			}

		})
		$(".btn-success").click(function() {
			if (confirm("确认添加图书吗")) {

				// 					location.href="/myjsp2/carddel.jsp?id="+a;
				location.href = "/myjsp3/bookaddstz";

			}

		})

	});
	
	
	</script>


</body>
</html>
