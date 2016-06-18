<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="col-lg-4">

    <form class="bs-example bs-example-form" data-example-id="simple-input-groups" action="/IOServlet" method="post" enctype="multipart/form-data">
        <br>

        <br>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon1" >文件描述</span>
            <input type="text" class="form-control" placeholder="请对文件进行描述" name="desc" aria-describedby="basic-addon1">
        </div>
        <br>

        <br>
        <div class="input-group">
            <span class="input-group-addon" >选择文件</span>
            <input type="file" class="form-control" aria-label="Amount (to the nearest dollar)" name="doc">

        </div>
        <button class="btn btn-primary">保存</button>
    </form>


</div>

</body>
</html>
