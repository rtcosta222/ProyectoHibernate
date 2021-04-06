<%-- 
    Document   : web11consultasespeciales
    Created on : 05-abr-2021, 12:43:21
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="controller" class="controllers.Controller11ConsultasEspeciales" scope="request"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate - Consultas Especiales</title>
    </head>
    <body>
        <h1>Hibernate - Consultas Especiales</h1>
        <form method="post">
            <label>DeptNo: </label>
            <input type="text" name="cjdeptno" required/>
            <button type="submit">Mostrar resumen</button>
        </form>
        <hr/>
    <%  String ui = request.getParameter("cjdeptno");
        if(ui != null){
            int deptno = Integer.parseInt(ui);
    %>      <%=controller.getResumen(deptno)%>
    <%  }
    %>    
    </body>
</html>
