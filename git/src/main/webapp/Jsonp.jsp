<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DICT</title>
</head>
<body>
<div class="container">
    <h3 class="page-header">电子词典</h3>
    <input type="text" id="jsonpINput">
    <button id="btn">翻译</button>
    <p id="result"></p>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $("#jsonpINput").keyup(function () {
        var value=$("#jsonpINput").val();
        var url="http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=jsonp&callback=?&version=1.1";
        $.getJSON(url,{"q":value}, function (data) {
            console.log(data);
            var dataArrt=data.basic.explains;
            var str="";
            for(var i=0;i<dataArrt.length;i++){
                var dataOne=dataArrt[i];
                str+=dataOne+"<br>"


            }
            console.log(str);
            $("#result").html(str);

        })


    })

</script>
</body>
</html>
