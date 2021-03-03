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
falta ....
<jsp:useBean
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
