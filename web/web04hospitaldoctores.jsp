<%-- 
    Document   : web04hospitaldoctores
    Created on : 25-feb-2021, 19:10:48
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
<jsp:useBean id="controllerhospital" class="controllers.Controller04HospitalDoctores" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate</title>
    </head>
    <body>
        <h1>Lista de Hospitales</h1>
        <table>
            <thead>
                <tr>
                    <th>Cod.</th>
                    <th>Nombre</th>
                    <th>Dirección</th>                    
                    <th>Teléfono</th>
                    <th>Num camas</th
                    <th></th>
                </tr>
            </thead>
            <tbody>
                    <%=controllerhospital.getHospitales()%>
            </tbody>
        </table>
    </body>
</html>
