<%-- 
    Document   : web091procedimientodoctor
    Created on : 05-mar-2021, 3:10:30
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller091Procedimiento" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Consultas de Acción con PLSQL procedures</title>
    </head>
    <body>
        <h1>Procedimientos Almacenados HQL</h1>
    <%  String ui = request.getParameter("iddoc");
        if(ui != null) {
            int z_iddoc = Integer.parseInt(ui);
            String z_especialidad = request.getParameter("especialidad");
            controller.updateEspecialidadDoctor(z_iddoc, z_especialidad);
        }
    %>
        <form method="get">
            <label>Intro. doctorNo</label>
            <input type="text" name="iddoc" placeholder="Id. de doctor" required/>
            <label>Intro. nueva especialidad</label>
            <input type="text" name="especialidad" place holder="Especialidad" required/>
            <button type="submit">Cambiar especialidad</button>
        </form>
        
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>Núm. Doctor</th>
                    <th>Hosp. Cod.</th>
                    <th>Apellido</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getDoctores()%>
            </tbody>
        </table>
    </body>
</html>
