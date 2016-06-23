var xmlHttp= function () {
    function creatxmlHttp(){
        var xmlHttp="null";
        if(window.ActiveXObject){
            xmlHttp=new ActiveXObject("Microsoft.Xmlhttp");


        }else{
            xmlHttp=new XMLHttpRequest();
        }
        return xmlHttp;

    }
    return{xmlHttp:creatxmlHttp}

}
