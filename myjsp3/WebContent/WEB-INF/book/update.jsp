<%@page import="com.it.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.it.entity.Card"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>图书管理</title>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
	padding-top: 50px;
}

.starter-template {
	padding: 40px 15px;
	text-align: center;
}

td {
	text-align: left;
}

.h32 {
	visibility: hidden;
}

.h31 {
	visibility: hidden;
}
</style>

</head>

<body>
	<%@ include file="tfbody.jsp"%>
	
	
	

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title btn-danger h31">图书修改失败请重新输入</h3>
					<h3 class="panel-title btn-success h32">图书修改</h3>
					<h3 type="hidden" id="flag" data="${param.id }"
						class="panel-title btn-success h32"></h3>
				</div>
				<div class="panel-body">
					<form id="signupForm" method="post" class="form-horizontal"
						action="/myjsp3/bookmodify" novalidate="novalidate">
						<input type="hidden" value="${list.id }" name="id" />
						<div class="form-group">
							<label class="col-sm-4 control-label" for="code">卡号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="code" name="code"
									placeholder="${list.code }" value="${list.code }">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="title">书名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="title" name="title"
									placeholder="${list.title }" value="${list.title }">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="author">作者</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="author"
									name="author" placeholder="${list.author }" value="${list.author }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" for="publishing">出版社</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="publishing"
									name="publishing" placeholder="${list.publishing }" value="${list.publishing }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" for="total">总数</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="total" name="total"
									placeholder="${list.total }" value="${list.total }">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" for="count">剩余数量</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="count"  name="count"
									
									placeholder="${list.count }" value="${list.count }">
							</div>
						</div>

						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button type="submit" class="btn btn-primary" name="signup"
									value="添加">添加</button>
								<button type="submit" class="btn btn-success" name="signup"
									value="返回">返回</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4"></div>
						</div>
					</form>
				</div>
			</div>
			<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
			<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
			<script src="/myjsp3/js/jquery.validate.min.js"></script>
			<script>
				$("ul.nav>li:nth-child(3)").addClass("active");
				$(function() {
					$("#signupForm").validate({
						rules : {
							code : "required",
							title : "required",
							author : "required",
							publishing : "required",
							total : "required",
							count : "required"
						},
						messages : {
							code : "请输入书号",
							title : "请输入书名",
							author : "请输入作者名",
							publishing : "请输入出版社",
							total : "请输入总数",
							count : "请输入剩余数量"
						},
						errorElement : "span"
					});
					$("h3").bind("myEvent", function() {
						console.log("123");
						var flag = $("#flag").attr("data");

						if (flag == "true") {
							$("h3.btn-danger").css('visibility', 'visible');
						} else {
							$("h3.btn-success").css('visibility', 'visible');
							// 							location.href = "/myjsp2/cardhome.jsp";
						}
					}).trigger("myEvent");
					$("div>button.btn-success").click(function(){
						console.log("123click");
						if (confirm("确认要取消修改吗吗")) {

							// 					location.href="/myjsp2/carddel.jsp?id="+a;
							location.href = "/myjsp3/bookControls";

						}
					})
				});
			</script>
		</div>

	</div>




</body>
</html>
