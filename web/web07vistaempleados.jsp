<%-- 
    Document   : web07vistaempleados
    Created on : 02-mar-2021, 18:29:01
    Author     : lscar
    SQL        :
        create or replace view vistaempleados
        as     
           select emp.apellido, 
                  emp.salario*12 as anual, 
                  emp.oficio, 
                  to_char(fecha_alt, 'dd " de " month " de " yyyy') as fechaalta,
                  dept.dnombre as departamento, 
                  dept.loc as localidad
           from emp
           inner join dept
           on emp.dept_no = dept.dept_no; 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllervistaemp" class="controllers.Controller07VistaEmpleados" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Vista Empleado</title>
    </head>
    <body>
        <h1>Vista Empleados</h1>
        <form method="post">
            <label>Introduzca localidad: </label>
            <input type="text" name="loc" required/>
            <button type="submit">Buscar empleados</button>
        </form>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Oficio</th>
                    <th>Departamento</th>
                    <th>Fecha Alta</th>
                    <th>Localidad</th>
                    <th>Salario Anual</th>
                </tr>
            </thead>
            <tbody>
            <%  String loc = request.getParameter("loc");
                if(loc != null) {
            %>      <%=controllervistaemp.getTablaEmpleadosLocalidad(loc)%>
            <%  } else {
            %>      <%=controllervistaemp.getTablaVistaEmpleados()%>
            <%  }
            %>
            </tbody>
        </table>
    </body>
</html>
