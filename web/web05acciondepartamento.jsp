<%-- 
    Document   : web05acciondepartamento
    Created on : 01-mar-2021, 16:25:56
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller05AccionDepartamento" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Consultas de Acción</title>
    </head>
    <body>
        <%  String ui = request.getParameter("cajanumero");
            if(ui != null) {
                int num = Integer.parseInt(ui);
                String nom = request.getParameter("cajanombre");
                String loc = request.getParameter("cajaloc");
                String accion = request.getParameter("accion");     
                if(accion.equalsIgnoreCase("insertar")) {
                    controller.insertarDepartamento(num, nom, loc);                
                } else if(accion.equalsIgnoreCase("eliminar")) {
                    controller.eliminarDepartamento(num);
                } else if(accion.equalsIgnoreCase("modificar")) {
                    controller.modificarDepartamento(num, nom, loc);
                }
            } 
        %>
        
        <h1>Consultas de Acción - Insertar Dept.</h1>
        <form method="post">
            <label>Número: </label>
            <input type="text" name="cajanumero" placeholder="Numero"/><br/>
            <label>Nombre: </label>
            <input type="text" name="cajanombre" placeholder="Nombre"/><br/>
            <label>Localidad: </label>
            <input type="text" name="cajaloc" placeholder="Localidad"/><br/>
            <button type="submit" name="accion" value="insertar">Insertar Dept.</button>
            <button type="submit" name="accion" value="eliminar">Eliminar Dept.</button>
            <button type="submit" name="accion" value="modificar">Modificar Dept.</button>
        </form>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>Número</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
