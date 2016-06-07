<%@page import="com.it.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.it.entity.Card"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>会员管理</title>
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
					<h3 class="panel-title btn-danger h31">会员添加失败请重新输入</h3>
					<h3 class="panel-title btn-success h32">会员添加</h3>
					<h3 type="hidden" id="flag" data="${param.id }"
						class="panel-title btn-success h32"></h3>
				</div>
				<div class="panel-body">
					<form id="signupForm" method="post" class="form-horizontal"
						action="/myjsp3/cardaddtj" novalidate="novalidate">
						<input type="hidden" value="" name="id" />
						<div class="form-group">
							<label class="col-sm-4 control-label" for="code">卡号</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="code" name="code"
									placeholder="请输入卡号" value="">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="title">姓名</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="name" name="name"
									placeholder="请输入姓名" value="">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-4 control-label" for="author">电话</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="tel"
									name="tel" placeholder="请输入电话" value="">
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
				$("#cardcontrol").addClass("active");
				$(function() {
					$("#signupForm").validate({
						rules : {
							code : "required",
							name : "required",
							tel : "required",
						
						},
						messages : {
							code : "",
							name : "",
							tel : "",
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
