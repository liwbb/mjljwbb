<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
</head>
<body>
<div class="container">
    <button id="btn1">get json</button>
    <button id="btn2"> ajax method</button>
    <img src="/static/img/ajax-loader.gif" id="img" style="display: none">

</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.validate.min.js"></script>
<script>
    $(function () {
        
        $("#btn2").click(function () {
            var $this=$(this);
            $.ajax({
                url:"/user.jsons",
                data:{"name":"Tom"},
                type:"get",
                timeout:10000,
                success: function (data) {
                    console.log(data[0].name);

                },
                error: function () {
                    alert("连接服务器失败")

                },
                complete: function () {
                    console.log("查询资料结束");
                    $this.text("ajax json").removeAttr("disabled");
                    $("img").hide();
                },

            beforeSend: function () {
                console.log("加载开始")
                $this.text("loading....").attr("disabled","disabled");
                $("img").show();


                }




            })

        });
        $("#btn1").click(function () {
            $.getJSON("/user.jsons", function (data) {
                console.log("Json")

            })
                    .done(function (data) {
                        console.log(data);
                        
                    })
                    .fail(function () {
                        console.log("连接服务器失败");

                    })
                    .always(function () {
                        console.log("always~~~~~~~~~~~~~");

                    })

        })


    })





</script>

</body>
</html>
