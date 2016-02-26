<%@page import="com.unal.exams.Presentation.Servlet.ExamsServlet"%>
<%@page import="java.util.Collection"%>
<%@page import="com.unal.exams.DataAccess.Entity.Exams"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Examenes</h1>
        <table>
            <%
                Collection<Exams> lista = ExamsServlet.loadExams();
                out.println("<tr>");
                    out.println("<td>ID             </td>");
                    out.println("<td>Nombre             </td>");
                    out.println("<td>Descripción        </td>");
                    out.println("<td>Fecha           </td>");
                    out.println("</tr>");
                for( Exams myExam : lista)
                {
                    out.println("<tr>");
                    out.println("<td>"+myExam.getExamId()+"               "+"</td>");
                    out.println("<td>"+myExam.getName()+"               "+"</td>");
                    out.println("<td>"+myExam.getDescription()+"              "+"</td>");
                    out.println("<td>"+myExam.getRealizationDate()+"             "+"</td>");
                    out.println("<td>");
                  
                    
                    
                    out.println("</td");
                    out.println("</tr>");
                }
            %>
        </table>
        
        <h1>Incribir </h1>
        <h2>(Ingresar ID)</h2>
        <form action="./RegExamServlet" method="post" >
                <input type="number" name = "idExam" >
                <input type="submit" value="Incribirse"/>
         </form>
        
    </body>
</html>