<%-- 
    Document   : adminExams
    Created on : 24-feb-2016, 21:24:20
    Author     : alej0
--%>

<%@page import="com.unal.exams.Presentation.Bean.ExamBean"%>
<%@page import="java.util.Collection"%>
<%@page import="com.unal.exams.DataAccess.Entity.Exams"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exámenes</title>
        <link rel="stylesheet" href="../resources/css/jquery-ui.css" type="text/css"/>
        <link rel="stylesheet" href="../resources/dataTables/css/jquery.dataTables.min.css" type="text/css"/>
    </head>
    <body>
        <h1>Exámenes</h1>
        <table id="table-exams" class="display" cellspacing="0" width="100%">
            <%
                ExamBean examBean = new ExamBean();
                Collection<Exams> exams = ExamBean.loadExams();
                out.println("<thead>");
                out.println("<tr>");
                    out.println("<th>ID</th>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Descripción</th>");
                    out.println("<th>Fecha de publicación</th>");
                    out.println("<th>Fecha de presentación</th>");
                    out.println("<th>Actualizar</th>");
                    out.println("<th>Eliminar</th>");
                out.println("</tr>");
                out.println("</thead>");
                out.println("<tfoot>");
                out.println("<tr>");
                    out.println("<th>ID</th>");
                    out.println("<th>Nombre</th>");
                    out.println("<th>Descripción</th>");
                    out.println("<th>Fecha de publicación</th>");
                    out.println("<th>Fecha de presentación</th>");
                    out.println("<th>Actualizar</th>");
                    out.println("<th>Eliminar</th>");
                out.println("</tr>");
                out.println("</tfoot>");
                
                out.println("<tbody>");
                for( Exams exam : exams){
                    out.println("<tr>");
                        out.println("<td>"+exam.getExamId()+"</td>");
                        out.println("<td>"+exam.getName()+"</td>");
                        out.println("<td>"+exam.getDescription()+"</td>");
                        out.println("<td>"+exam.getExpeditionDate()+"</td>");
                        out.println("<td>"+exam.getRealizationDate()+"</td>");
                        out.println("<td><button type='button' id='"+exam.getExamId()+"' class='btn-update btn btn-default'>Actualizar</button></td>");
                        out.println("<td><button type='button' id='"+exam.getExamId()+"' class='btn-delete btn btn-default'>Actualizar</button></td>");
                    out.println("</tr>");
                }
                out.println("</tbody>");
            %>
        </table>
        <script src="../resources/js/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="../resources/js/jquery-ui.js"></script>
        <script src="../resources/dataTables/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script>
            $(document).ready(function() {
                $('.btn-update').click(function(){
                    alert( $(this).attr("id") )
                });
                $('.btn-delete').click(function(){
                    /*$.ajax({
                        type: "post",
                        url: "/ExamsServlet",
                        data: {
                            id: $(this).attr("id")
                        },
                        success: function(msg){      
                            alert("hola")
                        },
                        error: function(msg,a,b){
                            alert("error " + b);
                        }
                    });*/
                });
                $('#table-exams').dataTable({
                    "language": {
                        "lengthMenu": "Mostrar _MENU_ resultados por página",
                        "zeroRecords": "No se encontraron resultados",
                        "info": "Mostrando página _PAGE_ de _PAGES_",
                        "infoEmpty": "No hay registros guardados",
                        "infoFiltered": "(filtrado entre _MAX_ resultados)",
                        "loadingRecords": "Cargando...",
                        "processing": "Procesando...",
                        "search": "Buscar:",
                        "paginate": {
                            "first": "Primera",
                            "last": "Última",
                            "next": "Siguiente",
                            "previous": "Anterior"
                        }
                    }
                });
            } );
        </script>
    </body>
</html>
