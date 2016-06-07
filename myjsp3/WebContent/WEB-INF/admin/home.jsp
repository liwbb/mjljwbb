<%@page import="com.it.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.it.entity.Card"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<title>借书管理</title>
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


	<c:choose>
		<c:when test="${'100'==param.msg }">
			<div class="alert alert-success alert-dismissible fade in"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>借书成功！</strong>
			</div>
		</c:when>
		<c:when test="${'101'==param.msg }">
			<div class="alert alert-success alert-dismissible fade in"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>借书失败！</strong>
			</div>
		</c:when>
		<c:when test="${'200'==param.msg }">
			<div class="alert alert-success alert-dismissible fade in"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>还书成功！</strong>
			</div>
		</c:when>
		<c:when test="${'201'==param.msg }">
			<div class="alert alert-success alert-dismissible fade in"
				role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>还书失败！</strong>
			</div>
		</c:when>

	</c:choose>

	<div class="panel panel-default">
		<h3 class="panel-title btn-success">借阅书籍</h3>


		<div class="panel-body">
			<form id="borrowBook" method="post" class="form-horizontal"
				action="/myjsp3/borrowBook" novalidate="novalidate">
				<input type="hidden" value="" name="id" />
				<div class="form-group">
					<label class="col-sm-4 control-label" for="cardCode">借书证卡号</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="cardCode"
							name="cardCode" placeholder="${list.cid} " value="${list.cid} ">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-4 control-label" for="bookCode">书籍编号</label>
					<div class="col-sm-5">
						<input type="text" class="form-control" id="bookCode"
							name="bookCode" placeholder="${list.bid} " value="${list.bid} ">
					</div>
				</div>




				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-4">
						<button type="submit" class="btn btn-primary" name="signup"
							value="添加">添加</button>

					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-9 col-sm-offset-4"></div>
				</div>

			</form>

		</div>


	</div>


	<div class="panel panel-default">
		<h3 class="panel-title btn-success">归还书籍</h3>


		<div class="panel-body">
			<button type="button"  id="button" action="/myjsp3/guiHuanBook" class="btn btn-lg btn-danger bs-docs-popover"
				data-toggle="popover" title=""
				data-content="And here's some amazing content. It's very engaging. Right?"
				data-original-title="Popover title" aria-describedby="popover240445">归还书籍</button>

		</div>


	</div>

	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="/myjsp3/js/jquery.validate.min.js"></script>
	<script>
		$("#home").addClass("active");
		$(function() {
			$("#signupForm").validate({
				rules : {
					cardCode : "required",
					bookCode : "required",

				},
				messages : {
					cardCode : "",
					bookCode : "",

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
			$("#button").click(function(){
				location.href="/myjsp3/guiHuanBook"
			})

		});
	</script>
	</div>

	</div>




</body>
</html>
