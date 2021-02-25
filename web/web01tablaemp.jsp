<%-- 
    Document   : webtablaemp
    Created on : 24-feb-2021, 20:31:06
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controlleremp" class="controllers.ControllerEmp" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primer Hibernate</title>
    </head>
    <body>
        <h1>Tabla Emp</h1>
        <table border='1'>
            <thead>
                <tr><th>EMP_NO</th><th>Apellido</th><th>Oficio</th></tr>
            </thead>
            <tbody>
                <%=controlleremp.getTablaEmp()%>
            </body>
        </table>
</html>
