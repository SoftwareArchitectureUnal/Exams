<%-- 
    Document   : examRegister
    Created on : 22-feb-2016, 22:27:48
    Author     : yeisondavid
--%>

<%@page import="java.util.Iterator"%>
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
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <%
                Collection<Exams> lista = ExamRegisterController.allExams();
                for( Exams myExam : lista)
                {
                    out.println("<tr>");
                    out.println("<td>"+myExam.getName()+"</td>");
//                    out.println("<td>"+lista.get(i).getNombre()+"</td>");
//                    out.println("<td>"+lista.get(i).getApellido()+"</td>");
//                    out.println("<td>"+lista.get(i).getTelefono()+"</td>");
                    out.println("</tr>");
                }
            %>
        </table>
    </body>
</html>
