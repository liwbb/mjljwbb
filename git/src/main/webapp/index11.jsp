<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajex</title>
</head>
<body>
<input name="username" id="username"><span id="userText"></span>

<script>
    function creat(){
        var xmlHttp="null";
        if(window.ActiveXObject){
            xmlHttp=new ActiveXObject("Microsoft.Xmlhttp");


        }else{
            xmlHttp=new XMLHttpRequest();
        }
        return xmlHttp;

    }

    document.querySelector("#username").onchange=function () {
        var xmlHttp=creat();
        var value=this.value;
        xmlHttp.open("get","/Ajex?username="+encodeURIComponent(value),true);
        xmlHttp.onreadystatechange= function () {
            var  redystatus=xmlHttp.readyState;
            if(redystatus==4){
                var status=xmlHttp.status;
                if(status=200){
                    var result=xmlHttp.responseText;
                    if(result=="no"){
                        document.querySelector("#userText").innerText="√";


                    }else{
                        document.querySelector("#userText").innerText="此账号已被占用";
                    }

                }
                else{
                    alert("响应失败："+xmlHttp)
                }

            }


        }
        xmlHttp.send();




    };


</script>

</body>
</html>
