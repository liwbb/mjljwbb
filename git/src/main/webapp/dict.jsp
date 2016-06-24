<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dict</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <H3>电子词典</H3>
    </div>
    <div class="form-group">
        <input type="text" id="keyword" class="form-control" placeholder="请输入你要翻译是的内容">
    </div>
    <p id="result"></p>
</div>

<script>
    (function () {
        function creat() {
            var xmlHttp = "null";
            if (window.ActiveXObject) {
                xmlHttp = new ActiveXObject("Microsoft.Xmlhttp");


            } else {
                xmlHttp = new XMLHttpRequest();
            }
            return xmlHttp;

        }


        document.querySelector("#keyword").onkeyup = function (event) {

            if (event.keyCode == 13) {
                var word = this.value;
                var xmlHttp = creat();
                xmlHttp.open("get", "/dict?p=" + encodeURIComponent(word), true);

                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState == 4) {
                        if (xmlHttp.status == 200) {
                            var dicDoc = xmlHttp.responseXML;
                            var basicArray = dicDoc.getElementsByTagName("basic");

                            console.log("basicArray" + basicArray.length);
                            for (var i = 0; i < basicArray.length; i++) {
                                var basic = basicArray[i];
                                console.log("basic" + basic);
                                var explainsArray = basic.getElementsByTagName("explains");
                                console.log("explainsArray:" + explainsArray.length);

                                for (var k = 0; k < explainsArray.length; k++) {
                                    var explains = explainsArray[k];

                                    var exArry = explains.getElementsByTagName("ex");
                                    console.log("exArry:" + exArry.length);

                                    var str = "";
                                    for (var j = 0; j < exArry.length; j++) {
                                        var ex = exArry[j];
                                        var dictWord = ex.childNodes[0].nodeValue;
                                        str += dictWord + "<br>"
                                        console.log("ex:" + dictWord);


                                    }
                                    document.querySelector("#result").innerHTML = str;


                                }


//                                var exArray=value.getElementsByTagName("ex");
//                                console.log("exArray"+exArray);
//                                for(var j=0;j<exArray.length;j++){
//                                    var ex=exArray[i];
//                                    console.log("ex"+ex);
//                                    var dictWord=ex.getElementsByTagName("ex")[0].childNode[0].nodeValue;
//                                    console.log("dictWord"+dictWord);
//
//                                }


                            }


                        }

                    }

                }
                xmlHttp.send()

            }


        }

    })()

</script>


</body>
</html>
