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
    <%  String ui = request.getParameter("deptno");
        if(ui != null) {
            int z_deptno = Integer.parseInt(ui);
            ui = request.getParameter("incr");
            int z_incr = Integer.parseInt(ui);
            controller.updateSalarioEmpleados(z_deptno, z_incr);
        }
    %>
        <form method="post">
            <label>Intro deptno: </label>
            <input type="text" name="deptno" placeholder="Núm. dept" required/>
            <label>Intro incremento salario: </label>
            <input type="text" name="incr" placeholder="Incremento salarial" required/>
            <button type="submit">Presionar</button>
        </form>
        
        <hr/>
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
                <%=controller.getEmpleados()%>
            </tbody>
        </table>
    </body>
</html>
