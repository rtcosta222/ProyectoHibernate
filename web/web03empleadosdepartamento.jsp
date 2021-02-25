<%-- 
    Document   : web03empleadosdepartamento
    Created on : 25-feb-2021, 16:55:34
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" 
             class="controllers.Controller3EmpleadosDepartamento" 
             scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HIBERNATE</title>
    </head>
    <body>
        <h1>Empleados por Dept</h1>
        <form method="post">
            <label>Seleccione departamento</label>
            <select name="selectdepartamento">
                <%=controller.getOptionsDepartamentos()%>
            </select>
            <button type="submit">Mostrar empleados</button>
        </form>
    </body>
</html>
