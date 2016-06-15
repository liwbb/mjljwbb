<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <c:choose>
        <c:when test="${param.code == 1001}">
            <div class="alert alert-danger">
                验证码错误
            </div>
        </c:when>
        <c:when test="${param.code == 1002}">
            <div class="alert alert-danger">
                用户名或密码错误
            </div>
        </c:when>
    </c:choose>

    <form action="/login" method="post" id="formButton">

        <div class="form-group">
            <label>账号</label>
            <input type="text" class="form-control" name="username">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input type="text" class="form-control" name="password" id="password">
        </div>
        <div class="form-group">
            <label>验证码</label>
            <input type="text" class="form-control" name="captcha">
            <a href="javascript:;" id="changePic"><img id="captcha" src="/captcha.png" alt=""></a>
        </div>
        <button class="btn btn-primary" type="button" id="button">登录</button>
    </form>


</div>


        <script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/core-min.js"></script>
<script src="/static/js/md5.js"></script>


<script>
    $(function(){

        $("#changePic").click(function(){
            //console.log("xxxx");
            $("#captcha").attr("src","/captcha.png?t="+new Date().getTime());


        });
        $("#button").click(function () {
            var password=$("#password").val();
            password=CryptoJS.MD5(password);
            $("#password").val(password);

            $("#formButton").submit();


        })



    });
</script>





</body>
</html>