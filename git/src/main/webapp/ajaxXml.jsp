<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xml</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3>Ajax读取XML</h3>
    </div>
    <button id="readBtn">Read</button>
    <div id="userBox">

    </div>
</div>

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

        function htmlxml() {
            var div = document.createElement("div");
            var h1 = document.createElement("h1");
            var h5 = document.createElement("h5")
            var h51 = document.createElement("h5")
            var h52 = document.createElement("h5")
            var h6 = document.createElement("h6")
            var span = document.createElement("span")
            var span1 = document.createElement("span")
            var h61 = document.createElement("h6")
            var span10 = document.createElement("span")
            var span11 = document.createElement("span")
            var h62 = document.createElement("h6")
            var span20 = document.createElement("span")
            var span21 = document.createElement("span")


        }

        document.getElementById("readBtn").onclick = function () {

            var xmlHttp = creat();
            xmlHttp.open("get", "/servletxml", true);
            xmlHttp.onreadystatechange = function () {
                var readyStates = xmlHttp.readyState;
                if (readyStates == 4) {
                    var status = xmlHttp.status;
                    if (status == 200) {
                        document.getElementById("userBox").innerHTML = "";
                        var xmlDoc = xmlHttp.responseXML;
                        console.log("xmlDoc:" + xmlDoc);
                        var userArray = xmlDoc.getElementsByTagName("user");


                        for (var i = 0; i < userArray.length; i++) {
                            var user = userArray[i];
                            var id = user.getAttribute("id");
                            var name = user.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                            var price = user.getElementsByTagName("price")[0].childNodes[0].nodeValue;
                            var authors = user.getElementsByTagName("author");


                            for (var j = 0; j < authors.length; j++) {
                                var author = authors[j];

                                if(j==0){
                                    var name = author.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                                    var address = author.getElementsByTagName("adress")[0].childNodes[0].nodeValue;


                                }if(j==1){
                                    var name1 = author.getElementsByTagName("name")[0].childNodes[0].nodeValue;
                                    var address1 = author.getElementsByTagName("adress")[0].childNodes[0].nodeValue;

                                }

                            }

                            console.log("name1"+name);


                            var gifts = user.getElementsByTagName("gift");


                            var elemnt=gifts[0].getElementsByTagName("theme")[0];



                            var boolean=(elemnt!=null);
                            console.log("boolean:"+boolean);

                            if(boolean==true){
                                for (var k = 0; k < gifts.length; k++) {

                                   var gift=gifts[k];

//                                    var theme=gifts[0].getElementsByTagName("theme")[0].childNodes[0].nodeValue;
//                                    var gname=gifts[0].getElementsByTagName("gname")[0].childNodes[0].nodeValue;
                                    var theme = gift.getElementsByTagName("theme")[0].childNodes[0].nodeValue;
                                    var gname = gift.getElementsByTagName("gname")[0].childNodes[0].nodeValue;

                                    console.log("theme"+theme+"gname"+gname);
                                }
                            }else{

                                continue;
                            }

                        }


                    }

                }

            }

            xmlHttp.send();

        }


    })()


</script>

</body>
</html>
