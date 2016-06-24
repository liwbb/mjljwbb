<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Polling</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>轮播查询</h3>
    </div>
    <a href="javascript:;" id="loadData">
        <div class="alert alert-info" style="display: none">

        </div>
    </a>
    <div id="message">

        <c:forEach items="${adminList}" var="msg">

            <div class="panel panel-default">
                <div class="panel panel-heading">
                    ${msg.name}
                </div>
                <div class="panel panel-heading">
                        ${msg.password}
                </div>

            </div>


        </c:forEach>
        
    </div>
</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/handlebars-v4.0.5.js"></script>
<script type="kaishengit/template" id="msgTemplate">
    <div class="panel panel-default">
        <div class="panel-heading" style="color: darkred">
            {{author}}
        </div>
        <div class="panel-body">
            {{msg}}
        </div>
    </div>
</script>

<script>
    $(function () {
        var newDat=null;

        var maxID=${maxID};
        console.log(maxID)


        $("#loadData").click(function () {
            var $message=$("#message");
            if(newDat){
                for(var i=newDat.length-1;i>=0;i--){
                    var messsage=newDat[i];
                    var source=$("#msgTemplate").html();
                    template=template.replace("{{author}}",messsage.name);
                    template=template.replace("{{msg}}",messsage.password)
                    $message.prepend(template);


                }
                maxID=newDat[0].id;
                newDat=null;
                $(".alert").hide();


            }


        })
//        setInterval(function () {
//                $.post("/pollingservlet",{"maxID":maxID}, function (masg) {
//                console.log(masg)
//                console.log("~~~~~~~~~"+masg.length)
//
//                if(masg.length>0){
//                    newDat=masg;
//
//                    $(".alert").text("有" + masg.length + "条新数据").show();
//
//                }
//
//
//
//            })
//        },5000)


//        setInterval(function(){
//            $.post("/pollingservlet",{"maxID":maxID},function(data){
//                if(data.length > 0) {
//                    newData = data;
//                    console.log("有" + data.length + "条新数据");
//                    $(".alert").text("有" + data.length + "条新数据").fadeIn();
//                }
//            });
//        },5000);



    })

</script>

</body>
</html>
