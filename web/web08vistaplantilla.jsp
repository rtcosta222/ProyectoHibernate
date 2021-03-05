<%-- 
    Document   : web08vistaplantilla
    Created on : 03-mar-2021, 5:46:32
    Author     : lscar
    Práctica   : Mostrar una vista con los datos de la plantilla: Apellido, función, 
                 salario, Nombre de hospital, Teléfono. Dibujamos los datos (en 
                 una tabla mismo). Posteriormente, realizamos un buscador por 
                 Hospital (nombre).
    Vista      : create or replace view vistaplantilla
                 as
                   select plantilla.apellido, 
                          plantilla.funcion, 
                          plantilla.salario,
                          hospital.nombre,
                          hospital.telefono
                   from plantilla
                   inner join hospital
                   on plantilla.hospital_cod = hospital.hospital_cod;
                   select * from vistaplantilla
--%>

<jsp:useBean id="controller" class="controllers.Controller08VistaPlantilla" scope="request"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - PLSQL Views</title>
    </head>
    <body>
        <h1>Plantilla por hospital:</h1>
        <form method="get">
            <label>Introduzca hospital: </label><br/>
            <input type="text" name="hnom" placeholder="Nombre hospital"/>
            <button type="submit">Buscar</button>
        </form>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Función</th>
                    <th>Salario</th>
                    <th>Nombre Hospital</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <%  String hnom = request.getParameter("hnom");
                    if (hnom != null) {
                %>      <%=controller.getVistaPlantillaHospital(hnom)%>
                <%  } else {
                %>      <%=controller.getVistaPlantillaHospitales()%>
                <%  }
                %>
            </tbody>
        </table>
    </body>
</html>
