<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Handlerbars.jsp</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h3>HARDLERBARS</h3>
    </div>
    <button id="btn">Load TEMPLATE</button>
    <div id="message" style="margin-top: 20px"></div>
</div>
<script src="/static/js/jquery-1.11.3.min.js"></script>
<script src="/static/js/handlebars-v4.0.5.js"></script>
<script type="text/x-handlebars-template" id="msghandlerbars">
    <div class="panel panel-default">
        <div class="panel-heading">
            {{author}}
            {{#if isvip}}
            <span class="alert-danger">vip</span>
            {{else}}
            <span class="alert-danger">♥</span>
            {{/if}}

        </div>
        <div class="panel-body">
            <ul>
                {{#each msg}}
                <li>{{this}}</li>
                {{/each}}
            </ul>
        </div>
    </div>

</script>
<script>

    $(function () {
        $("#btn").click(function () {
            var json={"author":"Tom","msg":["打车回家","运动半小时","请客吃饭"],"isvip":true};
            var source=$("#msghandlerbars").html();
            var complate=Handlebars.compile(source);
            var html=complate(json);
            $("#message").prepend(html);

        });

    })
</script>
</body>
</html>
