<%-- 
    Document   : web04doctoreshospital
    Created on : 25-feb-2021, 19:11:15
    Author     : lscar
    Práctica   : web04hospitaldoctores.jsp
    Dibujamos una (pequeña) tabla/lista con los hospitales y un enlace 
    para poder ver los doctores. Cuando pulsemos sobre el enlace, vamos 
    a la siguiente página:
    . web04doctoreshospital.jsp
        Mostramos los doctores
    . Dos repositorios:
        RepositoryDoctores
        RepositoryHospital
    . Un solo Controller
        Controller04HospitalDoctores
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdoctor" class="controllers.Controller04HospitalDoctores" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate</title>
    </head>
    <body>
        <h1>Doctores por Hospital</h1>
        <% String ui = request.getParameter("idhosp");
        if (ui != null) {
            int z_idhosp = Integer.parseInt(ui);
        %>  <table>
                <thead>
                    <tr>
                        <th>Doctor no.</th>
                        <th>Hosp no.</th>
                        <th>Apellido</th>                    
                        <th>Especialidad</th>
                        <th>Salario</th
                </tr>
            </thead>
            <tbody>
                    <%=controllerdoctor.getDoctores(z_idhosp)%>
            </tbody>
        </table>    
        <% } 
        %>
    </body>
</html>
