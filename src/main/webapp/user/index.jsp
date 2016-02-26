<%@page import="java.util.Collection"%>
<%@page import="com.unal.exams.BusinessLogic.Controller.User.ExamRegisterController"%>
<%@page import="com.unal.exams.DataAccess.Entity.Exams"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/menu.jspf" %>
        <form action="./RegisterExamServlet" method="post">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Examenes</div>
                <!-- Table -->
                <table class="table">
                    <%
                    Collection<Exams> lista = ExamRegisterController.allExams();
                    out.println("<tr>");
                        out.println("<th>Nombre             </th>");
                        out.println("<th>Descripción        </th>");
                        out.println("<th>Fecha           </th>");
                        out.println("<th>Inscrito           </th>");
                        out.println("</tr>");
                    for( Exams myExam : lista)
                    {
                        out.println("<tr>");
                        out.println("<td>"+myExam.getName()+"               "+"</td>");
                        out.println("<td>"+myExam.getDescription()+"              "+"</td>");
                        out.println("<td>"+myExam.getRealizationDate()+"             "+"</td>");
                        out.println("<td> <input type=\"checkbox\" name=\"checkb"+myExam.getExamId()+"\" >          </td>");;
                        out.println("</tr>");
                    }
                    %>
                </table>
            </div>
            <button type = "submit" class = "btn btn-success">Guardar</button>
        </form>   
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>