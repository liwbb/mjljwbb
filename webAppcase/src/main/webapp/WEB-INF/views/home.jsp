<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <style>

        tr:nth-child(6n-1) {
            background-color: gray;
        }

        tr:nth-child(6n-2) {
            background-color: yellow;
        }

        tr:nth-child(6n-3) {
            background-color: green;
        }

        tr:nth-child(6n-4) {
            background-color: white;
        }

        tr:nth-child(6n-5) {
            background-color: blue;
        }

        tr:nth-child(6n-6) {
            background-color: violet;
        }

    </style>

</head>
<body>
<div class="container">

    <div class="page-header">
        <h3>分页演示</h3>
    </div>

    <div class="panel panel-default">
        <div class="panel-heading">
            电影列表
        </div>
        <div class="panel-body">

            <table class="table">
                <thead>
                <tr class="info">
                    <th>影片名称</th>
                    <th>评分</th>
                    <th>导演</th>
                    <th>发行时间</th>
                    <th>上映时间</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${page.items}" var="doc">
                    <tr>
                        <td width="400">${doc.title}</td>
                        <td>${doc.rate}</td>
                        <td>${doc.releaseyear}</td>
                        <td>${doc.sendtime}</td>
                        <td>${doc.daoyan}</td>
                    </tr>


                </c:forEach>

                </tbody>
            </table>

        </div>

        <div class="panel-footer text-right">

            <ul class="pagination" id="page"></ul>
        </div>

    </div>


</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/jquery.twbsPagination.min.js"></script>
<script>
    $(function(){

        $("#page").twbsPagination({
            totalPages:${page.totalPages},
            visiblePages:10,
            first:'首页',
            prev:'上一页',
            next:'下一页',
            last:'末页',
            href:'?p={{number}}'
        });


    });
</script>


</body>
</html>