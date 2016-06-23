<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <input type="text" id="username"> <span id="innername"></span>
</head>
<body>

<script>


        function xmlhttp() {
            var xmlHttp = null;
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("micro");

            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;
        }

        document.querySelector("#username").onchange = function () {

            var value = this.value;
            var xmlHttp = xmlhttp();
            xmlHttp.open("get", "/ajex?username=" + value, true);
            xmlHttp.onreadystatechange = function () {
                var readystates=xmlHttp.readyState;
                if(readystates==4){
                    var states=xmlHttp.status;
                    if(states==200){
                        var result=xmlHttp.responseText;
                        if(result=="yes"){
                            document.querySelector("#innername").innerText="√";

                        }else{
                            document.querySelector("#innername").innerText="此账号已被占用";
                        }

                    }else{
                        alert("服务器响应异常"+states)
                    }

                }

            }

            xmlHttp.send();


        }




</script>

</body>
</html>
