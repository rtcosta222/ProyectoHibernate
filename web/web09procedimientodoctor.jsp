<%-- 
    Document   : web09Procedimientodoctor
    Created on : 03-mar-2021, 16:52:38
    Author     : lscar
    plsql proc.: create or replace procedure pr_updateespecialidaddoctor(
                                 p_iddoctor doctor.doctor_no%type,
                                 p_espe doctor.especialidad%type)
                 as
                 begin
                   update doctor set especialidad=p_espe where doctor_no=p_iddoctor;
                   commit;
                 end;
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller09Procedimiento" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Consultas de Acción con PLSQL procedures</title>
    </head>
    <body>
        <%  String dato = request.getParameter("cajadoctor");
            if(dato != null) {
                int iddoctor = Integer.parseInt(dato);
                String especialidad = request.getParameter("especialidad");
                controller.modificarEspecialidadDoctor(iddoctor, especialidad);
            }
        %>
        <h1>Procedimientos Almacenados HQL</h1>
        <form method="post">
            <label>Id doctor: </label>
            <input type="text" name="cajadoctor" required>
            <label>Nueva especialidad: </label>
            <input type="text" name="especialidad" required>
            <button type="submit">Modificar datos</button>
        </form>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>Id.</th>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDoctores()%>
            </tbody>
        </table>
    </body>
</html>
