<%-- 
    Document   : web10empleadosprocedimiento
    Created on : 03-mar-2021, 17:24:34
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller10EmpleadosProcedimiento" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Consultas de Acción con PLSQL procedures</title>
    </head>
    <body>
        <h1>Procedimientos Almacenados HQL</h1>
        <table>
            <thead>
                <tr>
                    <th>empNo</th>
                    <th>apellido</th>
                    <th>oficio</th>
                    <th>dir</th>
                    <th>fechaAlt</th>
                    <th>salario</th>
                    <th>comision</th>
                    <th>deptNo</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaEmp()%>
            </tbody>
        </table>
    </body>
</html>
