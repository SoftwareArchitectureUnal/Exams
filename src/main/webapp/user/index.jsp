

<%@page import="java.util.Date"%>
<%@page import="javafx.util.Pair"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.unal.exams.BusinessLogic.Controller.Reports.CertificationController"%>
<%@page import="com.unal.exams.DataAccess.Entity.Exams"%>
<%@page import="com.unal.exams.BusinessLogic.Controller.Management.ExamRegisterController"%>
<%@page import="com.unal.exams.DataAccess.Entity.Users"%>
<%@page import="java.util.Collection"%>
>
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
        <c:if test="${totalNotifications>0}">
            <div class="alert alert-success">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>There are some exams just around the corner!</strong> 
            </div>
        </c:if>
        <c:if test="${admin!=null}">
            <%
                request.getRequestDispatcher("/admin/index.jsp").forward(request, response);
            %>
        </c:if>
        <form action="./RegisterExamServlet" method="post">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Examenes</div>
                <!-- Table -->
                <table class="table">
                    <%
                    Collection<Pair<Exams, Boolean>> lista = ExamRegisterController.ExamsUser(((Users)session.getAttribute("user")).getUserId());
                    Boolean flag;
                    Exams exam;
                    out.println("<tr>");
                        out.println("<th>Nombre             </th>");
                        out.println("<th>Descripción        </th>");
                        out.println("<th>Fecha           </th>");
                        out.println("<th>Inscribir           </th>");
                        out.println("</tr>");
                    Date auxDate;
                    for( Pair myPair : lista)
                    {
                        
                        exam = (Exams)myPair.getKey();
                        auxDate = exam.getRealizationDate();
                        if ( auxDate.compareTo(new Date()) == -1) continue;
                        flag = (Boolean)myPair.getValue();
                        System.out.println("::: "+exam.getExamId()+" , "+flag);
                        out.println("<tr>");
                        out.println("<td>"+exam.getName()+"               "+"</td>");
                        out.println("<td>"+exam.getDescription()+"              "+"</td>");
                        out.println("<td>"+exam.getRealizationDate()+"             "+"</td>");
                        if ( flag )
                        {
                            out.println("<td> <input type=\"checkbox\" name=\"checkb"+exam.getExamId()+"\"  checked>          </td>"); 
                        }
                        else
                        {
                            out.println("<td> <input type=\"checkbox\" name=\"checkb"+exam.getExamId()+"\" >          </td>");
                        }
                        out.println("</tr>");
                    }
                    %>
                </table>
            </div>
            <button type = "submit" class = "btn btn-success" name = "btsave">Guardar</button>
        </form>   
                
                <br><br><br>   
        <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">Certificados</div>
                <!-- Table -->
                <table class="table">        
                <% Users myUser = (Users)session.getAttribute("user"); 
                    ArrayList<Exams> myExams = (ArrayList)CertificationController.getPasExamsofUser(myUser.getUserId());
                    out.print("<tr>");
                        out.print("<th>Exámenes</th>");
                    out.print("</tr>");
                    for( int i = 0; i < myExams.size(); i++ )
                    {
                       out.print("<tr>");
                       out.print("<td>"+(myExams.get(i).getName())+"</th>");
                       out.print("<td> <form action=\"./CertificationServlet\" method=\"post\"> "
                               + "<button type = \"submit\" class = \"btn btn-success\">Certificado</button>"
                               + "</form> </th>");
                       out.print("</tr>");
                    }
                %>
                
                
                </table>
        </div>
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
    </body>
</html>
