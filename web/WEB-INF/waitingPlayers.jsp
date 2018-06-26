
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            // Set refresh, autoload time as 5 seconds
            response.setIntHeader("Refresh", 10);
            
        %>
        <h1>Hello World!</h1>
    </body>
</html>
