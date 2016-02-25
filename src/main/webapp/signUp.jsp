<%-- 
    Document   : signUp
    Created on : Feb 24, 2016, 8:55:55 PM
    Author     : AndresGutierrez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="resources/css/signUp.css">
        <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="resources/js/jquery.js"></script>
        <script type="text/javascript" src="resources/js/signUp.js"></script>
      
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/menu.jspf" %>
        <c:if test="${signUp=='error'}" >
            <div class="alert alert-warning">
                <strong>Error!</strong> No se pudo hacer el registro
            </div>
        </c:if>
        <div class="container">
            <form  action="${pageContext.request.contextPath}/SignUpServlet" id="myForm" data-toggle="validator" class="form-signin" method="post">
                <h2 class="form-signin-heading">Por favor llene el formulario</h2>
                <label for="inputUsername" class="sr-only">Nombre de Usario</label>
                <input type="text" id="inputUsername" name="inputUsername" class="form-control"
                       placeholder="Nombre de usario" required autofocus>
                <label for="inputEmail" class="sr-only">Correo Electronico</label>
                <input type="emial" id="inputEmail" name="inputEmial" class="form-control"
                       placeholder="Direccion de correo" required>
                <label for="inputName" class="sr-only">Name</label>
                <input type="text" id="inputName" name="inputName" class="form-control"
                       placeholder="Nombre" required>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="inputPassword" onchange="checkPassword()" class="form-control"
                       placeholder="Contraseña" required>
                <label for="inputPassword" class="sr-only">Repeat Password></label>
                <input type="password" id="inputRepPassword" name="inputRepPassword" onchange="checkPassword()" class="form-control"
                       placeholder="Repita la contraseña" required>
               <select class="form-control" name="gender">
                    <option value="1">M</option>
                    <option value="2">F</option>
                
               </select>
                <button id="signUp" class="btn btn-lg btn-primary btn-block" type="submit" disabled="true">Registarse</button>
                 
                
            </form>
            
        </div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
