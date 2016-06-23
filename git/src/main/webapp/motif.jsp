<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dict</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.js">

</head>
<body>
<div class="container">
    <div class="page-header">
        RSS
    </div>
    <input type="text" id="url" class="col-lg-5">
    <button id="load_btn">Load</button>
    <ul class="list-unstyled" id="list">


    </ul>
</div>


<script>
    (function () {
        function creat(){
            var xmlHttp="";
            if(window.ActiveXObject){
                xmlHttp=new ActiveXObject("Micro-Xmlhttp");

            }else{
                xmlHttp=new XMLHttpRequest();
            }
            return xmlHttp

        }

        function creatTile(title, link) {
            var li=document.createElement("li");
            var a=document.createElement("a");
            var text=document.createTextNode(title);
            a.setAttribute("href",link);
            a.setAttribute("target","_blank");
            a.appendChild(text);
            li.appendChild(a);
            document.querySelector("#list").appendChild(li);

        }

        document.querySelector("#load_btn").onclick= function () {
            document.querySelector("#list").innerHTML="";
            var url=document.querySelector("#url").value;
            var xmlHttp=creat();
            xmlHttp.open("get","/loads?url="+url,true);
            xmlHttp.onreadystatechange= function () {
                if(xmlHttp.readyState==4){
                    if(xmlHttp.status==200){
                        var xmlDoc=xmlHttp.responseXML;
                        console.log(xmlDoc);
                        var items=xmlDoc.getElementsByTagName("item");
                        console.log(item);
                        for(var i=0;i<items.length;i++){
                            var item=items[i];
                            var title=item.getElementsByTagName("title")[0].childNodes[0].nodeValue;
                            var link=item.getElementsByTagName("link")[0].childNodes[0].nodeValue;
                            console.log("title:"+title+"link:"+link)

                            creatTile(title,link);
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
