<%-- 
    Document   : web03empleadosdept
    Created on : 28-feb-2021, 22:27:10
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdept" class="controllers.Controller03EmpleadosDepartamento" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Empleados/Dept</title>
    </head>
    <body>
        <h1>Empleados por Departamento</h1>
        <%  String ui = request.getParameter("selectdepartamento");
            if(ui != null) {
                int z_dept = Integer.parseInt(ui);
        %>      <%=controllerdept.getEmpleadosDepartamento(z_dept)%>
        <%
            }
        %>
    </body>
</html>