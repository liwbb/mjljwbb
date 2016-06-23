<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajex</title>
</head>
<body>


<form method="post" action="/ajex">

    请输入用户名：<input name="username" id="username" type="get"><span id="help_text" ></span><br><br>
    请输入密码：&nbsp;<input name="pwd" id="pwd" type="password"><br><br>
    <button type="submit" id="submit" value="提交">提交</button>

</form>




<script src="/static/js/Ajex.js"></script>
<script>


    (function () {



        document.querySelector("#username").onchange= function () {
            var value=this.value;
            Ajex.getGetCreat("/ajex?username="+encodeURIComponent(value), function (result) {


                if(result=="no"){
                    document.querySelector("#help_text").innerText="此账号已被占用";


                }else{
                    document.querySelector("#help_text").innerText="√";
                }

            })

        }




    })()




</script>

</body>
</html>
