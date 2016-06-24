<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPLOAD</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/js/upload/webuploader.css">

</head>
<body>
<div class="container">
    <div class="panel page-header">
        <h3>文件上传</h3>
    </div>
    <div id="picker">
        选择文件

    </div>
    <h3 >文件上次队列</h3>
    <ul id="fileList"></ul>

    <div ></div>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/upload/webuploader.min.js"></script>
<script>

    $(function () {
        var uploader=WebUploader.creat(function () {
            swf:"/static/js/upload/Uploader.swf";
            server:"/upload";
            fileVal:"file";
            pick:"#picker";
        })
        uploader.on("fileQueued", function (file) {
            var html = "<li id='"+file.id+"'>"+file.name+"</li>";
            $("#fileList").append(html);
            
        })



    })
</script>

</body>
</html>
