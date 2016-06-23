<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.js">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h3>RSS</h3>
    </div>
    <input type="text" id="url" class="col-xs-5">
    <button id="loadBtn">Load</button>
    <ul class="list-unstyled" id="list">

    </ul>



    <script>
        (function () {

            function createXmlHttp() {
                var xmlHttp = null;
                if(window.ActiveXObject) {
                    xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                } else {
                    xmlHttp = new XMLHttpRequest();
                }
                return xmlHttp;
            }
            function createLi(link,title) {
                var li = document.createElement("li");
                var a = document.createElement("a");
                var text = document.createTextNode(title);

                a.setAttribute("href",link);
                a.setAttribute("target","_blank");
                a.appendChild(text);
                li.appendChild(a);

                document.querySelector("#list").appendChild(li);
            }

            document.getElementById("loadBtn").onclick= function () {
                document.querySelector("#list").innerHTML = "";
                var xmlHttp=createXmlHttp();
                var url=document.getElementById("url").value;
                console.log(url)

                xmlHttp.open("get","/load?url="+url,true);
                xmlHttp.onreadystatechange= function () {
                    if(xmlHttp.readyState==4){
                        if(xmlHttp.status==200){
                            var xmlDoc=xmlHttp.responseXML;
                            var items=xmlDoc.getElementsByTagName("item");
                            console.log(items)

                            for(var i=0;i<items.length;i++){
                                var item=items[i];
                                var title=item.getElementsByTagName("title")[0].childNodes[0].nodeValue;
                                var link=item.getElementsByTagName("link")[0].childNodes[0].nodeValue;

                                createLi(link,title);
                            }


                        }

                    }

                }
                xmlHttp.send();



            }


        })()
    </script>


</div>

</body>
</html>
