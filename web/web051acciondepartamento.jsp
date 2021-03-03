<%-- 
    Document   : web051acciondepartamento
    Created on : 03-mar-2021, 3:24:46
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller051AccionDepartamento" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remake</title>
    </head>
    <body>
        <%  String ui = request.getParameter("eliminar");
            if(ui != null) {
                int dnumero = Integer.parseInt(ui);
                controller.eliminarDepartamento(dnumero);
            }
            
            ui = request.getParameter("dnum");
            if(ui != null) {
                int dnum = Integer.parseInt(ui);
                String dnom = request.getParameter("dnom");
                String dloc = request.getParameter("dloc");
                String accion = request.getParameter("accion");
                if (accion.equals("eliminar")) {
                    controller.eliminarDepartamento(dnum);
                } else if(accion.equals("modificar")) {
                    controller.modificarDepartamento(dnum, dnom, dloc);
                } else if (accion.equals("insertar")) {
                    controller.insertarDepartamento(dnum, dnom, dloc);
                }
            }
        %>
        
        <h1>Tabla Dept - Consultas de Acción</h1>
        <form method="get">
            <label>Número </label>
            <input type="text" name="dnum" placeholder="Número" required/><br/>
            <label>Nombre </label>
            <input type="text" name="dnom" placeholder="Nombre"/><br/>
            <label>Localidad </label>
            <input type="text" name="dloc" placeholder="Localidad"/><br/>
            <button type="submit" name="accion" value="insertar">Insertar</button>
            <button type="submit" name="accion" value="modificar">Modificar</button>
        </form>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>Número</th>
                    <th>Nombre</th>
                    <th>Localidad</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=controller.getTablaDepartamentos()%>
            </tbody>
        </table>
    </body>
</html>
