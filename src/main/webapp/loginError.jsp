<%-- 
    Document   : loginError
    Created on : Feb 25, 2016, 12:26:25 AM
    Author     : AndresGutierrez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/menu.jspf" %>
        <div class="alert alert-danger">
                <strong>Error!</strong> No se pudo hacer el log in
        </div>
        <%@include file="/WEB-INF/jspf/login.jspf" %>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
