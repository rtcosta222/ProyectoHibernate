<%-- 
    Document   : web06acciondoctor
    Created on : 02-mar-2021, 0:01:56
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controllerdoctor" class="controllers.Controller06AccionDoctor" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Tabla Doctor</title>
    </head>
    <body>
        <%  String uidel = request.getParameter("delete");
            if(uidel != null) {
                int z_docno = Integer.parseInt(uidel);
                controllerdoctor.eliminarDoctor(z_docno);
            }
            
            String ui = request.getParameter("cjdocno");
            if(ui != null) {
                int z_docn = Integer.parseInt(ui);
                String z_accion = request.getParameter("accion"); 
                if(z_accion.equalsIgnoreCase("eliminar")) {
                    controllerdoctor.eliminarDoctor(z_docn);
                } else {
                    ui = request.getParameter("cjhcod");
                    int z_hcod = Integer.parseInt(ui);
                    String z_ape = request.getParameter("cjape");
                    String z_espe = request.getParameter("cjespe");
                    ui = request.getParameter("cjsal");
                    int z_sal = Integer.parseInt(ui);
                    if(z_accion.equalsIgnoreCase("insertar")) {
                        controllerdoctor.insertarDoctor(z_hcod, z_docn, z_ape, z_espe, z_sal);
                    } else if(z_accion.equalsIgnoreCase("modificar")) {
                        controllerdoctor.modificarDoctor(z_hcod, z_docn, z_ape, z_espe, z_sal);
                    }
                }
            }
        %>
        <h1>Gestión tabla Doctor</h1>
        <form method="post">
            <label>Hospcod: </label>
            <input type="text" name="cjhcod" placeholder="Hospital_cod"/><br/>
            <label>Docno: </label>
            <input type="text" name="cjdocno" placeholder="Num. Doctor"/><br/>
            <label>Apellidos: </label>
            <input type="text" name="cjape" placeholder="Apellidos"/><br/>
            <label>Especialidad: </label>
            <input type="text" name="cjespe" placeholder="Especialidad"/><br/>
            <label>Salario </label>
            <input type="text" name="cjsal" placeholder="Salario"/><br/>
            <button type="submit" name="accion" value="insertar">Insertar</button>
            <button type="submit" name="accion" value="modificar">Modificar</button>
        </form>
        <hr/>
        <table>
            <thead>
                <tr>
                    <th>HospCod</th>
                    <th>DocNo</th>
                    <th>Apellidos</th>
                    <th>Especialidad</th>
                    <th>Salario</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%=controllerdoctor.getTablaDoctor()%>
            </tbody>
        </table>
    </body>
</html>
