<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json</title>
</head>
<body>
<br>
<button id="jsonBtn">get Json username</button>
<ul id="jsonList"></ul>
<br>
<form method="post" action="/ajex">

    请输入用户名：<input name="username" id="username" type="get"><span id="help_text" ></span><br><br>
    请输入密码：&nbsp;<input name="pwd" id="pwd" type="password"><br><br>
    <button type="submit" id="submit" value="提交">提交</button>
    <style>
        div{
            color:green;
        }
    </style>

</form>
<br>
<button id="xmlBtn">get XML data</button>
  
<div id="userBox">

</div>



<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function () {

        $("#xmlBtn").click(function () {
            $.get("/servletxml", function (data) {

                console.log(data);
               var $userBox= $("#userBox");
                $userBox.html("");
               $(data).find("user").each(function () {
                   var id = $(this).attr("id");
                   var names=$(this).find("names").text();

                   var name1 = $(this).find("name")[0].innerHTML;
                   if($(this).find("name").length==2){
                       var name2=$(this).find("name")[1].innerHTML;
                   }


                   console.log($(this).find("name")[0].innerHTML)
                   var address1 = $(this).find("adress")[0].innerHTML;
                   if($(this).find("adress").length==2){
                       var address2=$(this).find("adress")[1].innerHTML;
                   }
                   if($(this).find("adress").length==2){
                       $userBox.append("<div><h4>"+"书名:"+"&nbsp;"+names+"<br>"+"<br>"+"<small>"+"书籍id"+id+"</small></h4><p>"+"作者名"+"&nbsp;"+name1+"<br>"+"地址:"+"&nbsp;"+address1+"</p>" +
                               "<p>"+"作者名"+"&nbsp;"+name2+"<br>"+"地址:"+"&nbsp;"+address2+"</p></div>");
                   }else{
                       $userBox.append("<div><h4>"+"书名:"+"&nbsp;"+names+"<br>"+"<br>"+"<small>"+"书籍id"+id+"</small></h4><p>"+"作者名"+"&nbsp;"+name1+"<br>"+"地址:"+"&nbsp;"+address1+"</p>" +"</div>");
                   }

                   $userBox.append("----------------------<br>");







               })


            })

        })
        $("#username").change(function () {
            var name=$(this).val();
            var $help_text=$("#help_text");

            $.get("/ajex",{"username":name}, function (data) {
                if(data=="yes"){
                    $help_text.text("√");


                }else{
                    $help_text.text("此账号已被占用");

                }

            })

        })


        $("#jsonBtn").click(function () {
            console.log("user");
//            document.querySelector("#jsonList").innerHTML = "";
            var $ul=$("#jsonList");
            $ul.html("");
            $.get("/user.json", function (data) {
                console.log(data);
               for(var i=0;i<data.length;i++){
                   var user=data[i];

                   $ul.append("<li>"+user.name+"</li>");

               }


            })


        })




    })

</script>

</body>
</html>
