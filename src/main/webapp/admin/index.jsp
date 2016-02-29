<%-- 
    Document   : index
    Created on : 28-feb-2016, 10:37:01
    Author     : alej0
--%>

<%@page import="java.util.Collection"%>
<%@page import="com.unal.exams.DataAccess.Entity.Exams"%>
<%@page import="com.unal.exams.BusinessLogic.Controller.User.ExamController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exámenes</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.css" type="text/css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dataTables/css/dataTables.bootstrap.min.css" type="text/css"/>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/chart/Chart.min.js"></script>
        <!--<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/dataTables/css/jquery.dataTables.min.css" type="text/css"/>-->
    </head>
    <body>
        <div class="modal fade" id="modal-statistics" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Estadísticas</h4>
                    </div>
                    <div class="modal-body">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#registered-users">Usuarios registrados</a></li>
                            <li><a data-toggle="tab" href="#certified-users">Usuarios certificados</a></li>
                            <li><a data-toggle="tab" href="#exams-statistics">Exámenes</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="registered-users" class="tab-pane fade in active">
                            </div>
                            <div id="certified-users" class="tab-pane fade">bueno</div>
                            <div id="exams-statistics" class="tab-pane fade">chao</div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-deleted" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Eliminado</h4>
                    </div>
                    <div class="modal-body">
                        <p>El registro ha sido eliminado.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-saved" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Guardado</h4>
                    </div>
                    <div class="modal-body">
                        <p>El registro ha sido guardado.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-save" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Ingresar examen</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <label for="exam-name">Nombre</label><br/>
                                <input type="text" value="" id="exam-name" class="form-control"></input><br/>
                            <label for="exam-start-date">Fecha de expedición</label><br/>
                                <input styleClass="datepicker" value="" id="exam-start-date" class="form-control datepicker" autocomplete="off"></input><br/>
                            <label for="exam-date">Fecha de realización</label><br/>
                                <input type="text" value="" id="exam-date" class="form-control datepicker" autocomplete="off"></input><br/>
                            <label for="exam-cert-date">Fecha de certificación</label><br/>
                                <input type="text" value="" id="exam-cert-date" class="form-control datepicker" autocomplete="off"></input><br/>
                            <label for="exam-description">Descripción</label><br/>
                                <textarea type="text" value="" id="exam-description" rows="5" cols="50" class="form-control"></textarea><br/>
                                <button type="button" id="btn-save" class="btn btn-lg btn-primary btn-block">Guardar</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-updated" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Actualizado</h4>
                    </div>
                    <div class="modal-body">
                        <p>El registro ha sido actualizado.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-update" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Ingresar examen</h4>
                    </div>
                    <div class="modal-body">
                        <form>
                            <label>Id:&nbsp;</label><label id="id-up"></label><br/><br/>
                            <label for="exam-name-up">Nombre</label><br/>
                                <input type="text" value="" id="exam-name-up" class="form-control"></input><br/>
                            <label for="exam-start-date-up">Fecha de expedición</label><br/>
                                <input styleClass="datepicker" value="" id="exam-start-date-up" class="form-control datepicker" autocomplete="off"></input><br/>
                            <label for="exam-date-up">Fecha de realización</label><br/>
                                <input type="text" value="" id="exam-date-up" class="form-control datepicker" autocomplete="off"></input><br/>
                            <label for="exam-cert-date-up">Fecha de certificación</label><br/>
                                <input type="text" value="" id="exam-cert-date-up" class="form-control datepicker" autocomplete="off"></input><br/>
                            <label for="exam-description-up">Descripción</label><br/>
                                <textarea type="text" value="" id="exam-description-up" rows="5" cols="50" class="form-control"></textarea><br/>
                                <button type="button" id="btn-update" class="btn btn-lg btn-primary btn-block">Guardar</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="/WEB-INF/jspf/menu.jspf" %>
        
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <h1 class="text-primary">Exámenes</h1><br/>
                    <table id="table-exams" class="display table table-striped table-bordered table-hover" cellspacing="0" width="100%">
                        <%
                            ExamController examController = new ExamController();
                            Collection<Exams> exams = examController.findAll();
                            out.println("<thead>");
                            out.println("<tr>");
                                out.println("<th style='text-align: center;'>ID</th>");
                                out.println("<th style='text-align: center;'>Nombre</th>");
                                out.println("<th style='text-align: center;'>Descripción</th>");
                                out.println("<th style='text-align: center;'>Fecha de publicación</th>");
                                out.println("<th style='text-align: center;'>Fecha de presentación</th>");
                                out.println("<th style='text-align: center;'>Fecha de certificado</th>");
                                out.println("<th style='text-align: center;'>Actualizar</th>");
                                out.println("<th style='text-align: center;'>Eliminar</th>");
                            out.println("</tr>");
                            out.println("</thead>");
                            out.println("<tfoot>");
                            out.println("<tr>");
                                out.println("<th style='text-align: center;'>ID</th>");
                                out.println("<th style='text-align: center;'>Nombre</th>");
                                out.println("<th style='text-align: center;'>Descripción</th>");
                                out.println("<th style='text-align: center;'>Fecha de publicación</th>");
                                out.println("<th style='text-align: center;'>Fecha de presentación</th>");
                                out.println("<th style='text-align: center;'>Fecha de certificado</th>");
                                out.println("<th style='text-align: center;'>Actualizar</th>");
                                out.println("<th style='text-align: center;'>Eliminar</th>");
                            out.println("</tr>");
                            out.println("</tfoot>");

                            out.println("<tbody>");
                            for( Exams exam : exams){
                                out.println("<tr>");
                                    out.println("<td>"+exam.getExamId()+"</td>");
                                    out.println("<td>"+exam.getName()+"</td>");
                                    out.println("<td>"+exam.getDescription()+"</td>");

                                    if( exam.getExpeditionDate().getMonth() + 1 < 10 )
                                        out.println("<td style='text-align: center;'>"+exam.getExpeditionDate().getDate()+"/0"+exam.getExpeditionDate().getMonth()+"/"+(exam.getExpeditionDate().getYear()+1900)+"</td>");
                                    else
                                        out.println("<td style='text-align: center;'>"+exam.getExpeditionDate().getDate()+"/"+exam.getExpeditionDate().getMonth()+"/"+(exam.getExpeditionDate().getYear()+1900)+"</td>");

                                    if( exam.getRealizationDate().getMonth() + 1 < 10 )
                                        out.println("<td style='text-align: center;'>"+exam.getRealizationDate().getDate()+"/0"+exam.getRealizationDate().getMonth()+"/"+(exam.getRealizationDate().getYear()+1900)+"</td>");
                                    else
                                        out.println("<td style='text-align: center;'>"+exam.getRealizationDate().getDate()+"/"+exam.getRealizationDate().getMonth()+"/"+(exam.getRealizationDate().getYear()+1900)+"</td>");

                                    if( exam.getCertificationDate().getMonth() + 1 < 10 )
                                        out.println("<td style='text-align: center;'>"+exam.getCertificationDate().getDate()+"/0"+exam.getCertificationDate().getMonth()+"/"+(exam.getCertificationDate().getYear()+1900)+"</td>");
                                    else
                                        out.println("<td style='text-align: center;'>"+exam.getCertificationDate().getDate()+"/"+exam.getCertificationDate().getMonth()+"/"+(exam.getCertificationDate().getYear()+1900)+"</td>");

                                    out.println("<td style='text-align: center;'><button type='button' id='"+exam.getExamId()+"' class='btn-update btn btn-info'><span class='glyphicon glyphicon-refresh' aria-hidden='true'></span></button></td>");
                                    out.println("<td style='text-align: center;'><button type='button' id='"+exam.getExamId()+"' class='btn-delete btn btn-info'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button></td>");
                                out.println("</tr>");
                            }
                            out.println("</tbody>");
                        %>
                    </table><br/><br/><br/>
                    <div class="col-md-3">
                        <button type="button" id="btn-statistics" class="btn btn-lg btn-primary btn-block">Estadísticas</button>
                    </div>
                    <div class="col-md-3 col-md-offset-6">
                        <button type="button" id="btn-insert" class="btn btn-lg btn-primary btn-block">Nuevo</button><br/><br/>
                    </div>
                    <div class="col-md-12" style="text-align: center;">
                        <canvas id="users-chart" width="800" height="500"></canvas><br/><br/><br/><br/>
                    </div>
                </div>
            </div>
        </div>
        <!--<%@include file="/WEB-INF/jspf/footer.jspf" %>-->
        <script src="${pageContext.request.contextPath}/resources/js/jquery/dist/jquery.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/jquery-ui/jquery-ui.js"></script>
        <script src="${pageContext.request.contextPath}/resources/dataTables/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/dataTables/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function() {
                charts();
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
                    
                $("#btn-insert").click(function(){
                    $("#modal-save").modal();
                });
                $('#btn-save').click(function(){
                    $.ajax({
                        type: "post",
                        url: "AdminExamsServlet",
                        data: {
                            method: "insertExam",
                            name: $('#exam-name').val(),
                            expeditionDate: $('#exam-start-date').val(),
                            realizationDate: $('#exam-date').val(),
                            certificationDate: $('#exam-cert-date').val(),
                            description: $('#exam-description').val()
                        },
                        success: function(){      
                            $('#modal-save').modal('hide');
                            setTimeout(saved, 200);
                        },
                        error: function(msg,textStatus, errorThrown){
                            alert(errorThrown);
                        }
                    });
                });
                function saved(){
                    $('#modal-saved').modal();
                }
                $('.btn-update').click(function(){
                    var id = $(this).attr("id");
                    $("#modal-update").modal();
                    $("#id-up").text(id);
                    $.ajax({
                        type: "post",
                        url: "AdminExamsServlet",
                        data: {
                            method: "findExam",
                            id: id
                        },
                        success: function( data ){  
                            var exam = data.split(",");
                            $("#exam-name-up").val(exam[0]);
                            $("#exam-start-date-up").val(exam[1]);
                            $("#exam-date-up").val(exam[2]);
                            $("#exam-cert-date-up").val(exam[3]);
                            $("#exam-description-up").val(exam[4]);
                        },
                        error: function(msg, textStatus, errorThrown){
                            alert(errorThrown);
                        }
                    });
                });
                $('#btn-update').click(function(){
                    $.ajax({
                        type: "post",
                        url: "AdminExamsServlet",
                        data: {
                            method: "updateExam",
                            id: $("#id-up").text(),
                            name: $('#exam-name-up').val(),
                            expeditionDate: $('#exam-start-date-up').val(),
                            realizationDate: $('#exam-date-up').val(),
                            certificationDate: $('#exam-cert-date-up').val(),
                            description: $('#exam-description-up').val()
                        },
                        success: function(){      
                            $('#modal-update').modal('hide');
                            setTimeout(updated, 200);
                        },
                        error: function(msg,textStatus, errorThrown){
                            alert(errorThrown);
                        }
                    });
                });
                function updated(){
                    $('#modal-updated').modal();
                }
                $('.btn-delete').click(function(){
                    $.ajax({
                        type: "post",
                        url: "AdminExamsServlet",
                        data: {
                            method: "deleteExam",
                            id: $(this).attr('id')
                        },
                        success: function(){ 
                            $('#modal-deleted').modal();
                        },
                        error: function(msg,textStatus, errorThrown){
                            alert("Error "+errorThrown);
                        }
                    });
                });
                $(".datepicker").datepicker({
                    showOtherMonths: true, selectOtherMonths: true, changeMonth: true,
                    changeYear: true, numberOfMonths: 2, showWeek: true, minDate: 0
                });
                $(".datepicker").datepicker("option", "showAnim", "slideDown");
                $(".datepicker").datepicker("option", "dateFormat", "dd-mm-yy");
                $("#btn-statistics").click(function () {
                    //$('#modal-statistics').modal();
                });
                $('.nav-tabs a').click(function(){
                    //$(this).tab('show');
                });
                function charts(){
                    var results;
                    var examNames = [];
                    var examsApproved = [];
                    var examsFailed = [];
                    $.ajax({
                        type: "post",
                        url: "AdminExamsServlet",
                        data: {
                            method: "examResults"
                        },
                        success: function(data){ 
                            results = data.split("$$");
                            for(var i = 0; i < results.length; i++){
                                examNames.push(results[i].split("&&")[1]);
                                examsApproved.push(results[i].split("&&")[2]);
                                examsFailed.push(results[i].split("&&")[3]);
                            }
                            resultsChar(examNames, examsApproved, examsFailed);
                        },
                        error: function(msg,textStatus, errorThrown){
                            alert("Error "+errorThrown);
                        }
                    });
                }
                function resultsChar( examNames, examsApproved, examsFailed ){
                    var data = {
                        labels: examNames,
                        datasets: [
                            {
                                label: "Aprobaron",
                                fillColor: "rgba(220,220,220,0.5)",
                                strokeColor: "rgba(220,220,220,0.8)",
                                highlightFill: "rgba(220,220,220,0.75)",
                                highlightStroke: "rgba(220,220,220,1)",
                                data: examsApproved
                            },
                            {
                                label: "Fallaron",
                                fillColor: "rgba(151,187,205,0.5)",
                                strokeColor: "rgba(151,187,205,0.8)",
                                highlightFill: "rgba(151,187,205,0.75)",
                                highlightStroke: "rgba(151,187,205,1)",
                                data: examsFailed
                            }
                        ]
                    };


                    var options = { scaleBeginAtZero : true, scaleShowGridLines : true, scaleGridLineColor : "rgba(0,0,0,.05)", scaleGridLineWidth : 1,
                                    scaleShowHorizontalLines: true, scaleShowVerticalLines: true, barShowStroke : true, barStrokeWidth : 2,
                                    barValueSpacing : 5, barDatasetSpacing : 1, responsive: true
                                  };
                    var context = $("#users-chart").get(0).getContext("2d");
                    var chartUsers = new Chart(context).Bar(data, options);
                }
            });
        </script>
    </body>
</html>
