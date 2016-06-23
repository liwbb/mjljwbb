var Ajex=(function () {
    function creat(){
        var xmlHttp="null";
        if(window.ActiveXObject){
            xmlHttp=new ActiveXObject("Microsoft.Xmlhttp");


        }else{
            xmlHttp=new XMLHttpRequest();
        }
        return xmlHttp;

    }



    function buildQueryParam(isPost,obectParam){
        var querParam="";
        if(!isPost){
            querParam="?"

        }

        for(var index in obectParam){
            var key=index;
            var value=obectParam[index];
            querParam+=(key+"="+value+"&");

        }


        if(!isPost){
            querParam+="_="+new Date().getTime();

        }else{
            if(querParam.lastIndexOf("&")==querParam.length-1){
                querParam=querParam.substring(0,querParam.length-1)

            }


        }


        return querParam;


    }
    function getgetcreat(url,queryParam,fn){
        var args=arguments;

        var xmlHttp=creat();
        xmlHttp.open("get",url+buildQueryParam(false,queryParam),true);


        xmlHttp.onreadystatechange= function () {
            var  redystatus=xmlHttp.readyState;
            if(redystatus==4){
                var status=xmlHttp.status;
                if(status=200){
                    var result=xmlHttp.responseText;
                    if(args.length==2){

                        args[1](result);

                    }else if(args.length==3){
                        args[2](result);
                    }



                }
                else{
                    alert("响应失败："+xmlHttp)
                }

            }


        }
        xmlHttp.send();

    }
    function getpostcreat(url,queryParam,fn){
        var args=arguments;

        var xmlHttp=creat();


        xmlHttp.open("post",url,true);
        xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");



        xmlHttp.onreadystatechange= function () {
            var  redystatus=xmlHttp.readyState;
            if(redystatus==4){
                var status=xmlHttp.status;
                if(status=200){
                    var result=xmlHttp.responseText;
                    if(args.length==2){

                        args[1](result);

                    }else if(args.length==3){
                        args[2](result);
                    }



                }
                else{
                    alert("响应失败："+status)
                }

            }


        }
        xmlHttp.send(buildQueryParam(true,queryParam));

    }
    return {
        getGetCreat:getgetcreat,
        getPostCreat:getpostcreat

    }



})()
