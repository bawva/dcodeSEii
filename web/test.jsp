
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            var xmlHttp;
            function createRequest() {
                if (window.XMLHttpRequest) {
                    xmlHttp = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    xmlHttp = new ActiveXObject();
                } else {
                    alert("Please Update Your Browser!!!!");
                }
            }



            function loadProducts() {
                createRequest();
                var url = "testservlet";
                xmlHttp.open("GET", url, true);
                xmlHttp.send();
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                        var s = xmlHttp.responseText;
                        document.getElementById("cont1").innerHTML = s;
                    }
                }
            }
            var that = this;

            setTimeout(function () {   //calls click event after a certain time
                that.loadProducts();
            }, 1000);
        </script>
    </head>
    <body>

        <h1>Hello World!</h1>
        <div><button onclick="loadProducts();">Click</button></div>
        <div id="cont1">

        </div>
    </body>
</html>
