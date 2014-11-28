<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home Page</title>
        <script type="text/javascript">
            
            function sendRequest(){
                var xmlhttpRequest = new XMLHttpRequest;
                xmlhttpRequest.onreadystatechange = reloadPage;
                
                var stableSessionID = xmlhttpRequest.getResponseHeader("stableSessionID");
                var timestamp = xmlhttpRequest.getResponseHeader("timestamp");
                
                xmlhttpRequest.open("POST", "test.htm", false);
                xmlhttpRequest.setRequestHeader("stableSessionID", stableSessionID);
                xmlhttpRequest.setRequestHeader("timestamp", timestamp);
                
                xmlhttpRequest.send();
                
                function reloadPage(){
                    if (xmlhttpRequest.readyState == 4 && http.status == 200) {
                        var textout = xmlhttpRequest.responseText;
                        document.write.textout;
                    }
                }
            }
        </script>
    </head>
    <body>
        <h1>Home Page</h1>
        <p>
        </p>
        <p>
        </p>
        <p>
        </p>
        <div id="link" align="center">
            <a href="test.htm" onclick="sendRequest()">click here to test dao</a>
        </div>
    </body>
</html>
