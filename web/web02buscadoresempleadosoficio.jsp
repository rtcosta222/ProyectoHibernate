<%-- 
    Document   : web02buscadores empleadosoficio
    Created on : 25-feb-2021, 16:21:07
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerempleados" class="controllers.ControllerEmp" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate</title>
    </head>
    <body>
        <h1>Buscador de Empleados</h1>
        <form method="post">
            <label>Introduzca oficio: </label>
            <input type="text" name="cajaoficio" placeholder="Oficio"/>
            <button type="submit">Buscar empleados></button>
        </form>
        
        <%  String oficio = request.getParameter("cajaoficio");
            if (oficio != null) {
        %>      <%=controllerempleados.getEmpleadosOficio(oficio)%>
        <%  }
        %>
    </body>
</html>
