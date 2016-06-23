<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dict</title>
    <link rel="stylesheet" href="/static/js/bootstrap.min.js">
</head>
<body>
<dic class="container">
    <div class="page-header">
        电子词典
    </div>
    <div class="form-group">

        <input type="text" id="dict" placeholder="请输入你要翻译的词语">
    </div>
    <p class="form-control" id="result">

    </p>

</dic>

<script>
    (function () {
        function creatXmlHttp(){
            var xmlHttp="";
            if(window.ActiveXObject){
                xmlHttp=new ActiveXObject("MICRO_http");

            }else{
                xmlHttp=new XMLHttpRequest();
            }
            return xmlHttp;
        }
        document.querySelector("#dict").onkeyup= function (event) {
            var value=this.value;
            var xmlHttp=creatXmlHttp();
            if(event.keyCode==13){
                xmlHttp.open("get","/dict?p="+encodeURIComponent(value),true);
                xmlHttp.onreadystatechange= function () {
                    if(xmlHttp.readyState==4){
                        if(xmlHttp.status==200){
                            var xml=xmlHttp.responseXML;
                            var basics=xml.getElementsByTagName("basic");
                            for(var i=0;i<basics.length;i++){
                                var basic=basics[i];
                                var explains=basic.getElementsByTagName("explains");
                                for(var j=0;j<explains.length;j++){
                                    var explain=explains[i];
                                    var exx=explain.getElementsByTagName("ex");
                                    var str="";
                                    for(var k=0;k<exx.length;k++){
                                        var ex=exx[k];
                                        console.log(exx);
                                        var dictWord=ex.childNodes[0].nodeValue;
                                        str+=dictWord+"<br>";


                                        console.log("str"+str)
                                    }
                                    document.querySelector("#result").innerHTML=str;

                                }

                            }

                        }

                    }

                }
                xmlHttp.send();

            }






        }











    })()


</script>

</body>
</html>
