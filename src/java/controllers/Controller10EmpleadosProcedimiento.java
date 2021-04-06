/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Emp;
import repositories.RepositoryEmpleadosProcedimiento;

/**
 *
 * @author lscar
 */
public class Controller10EmpleadosProcedimiento {

    RepositoryEmpleadosProcedimiento repo;
    
    public Controller10EmpleadosProcedimiento() {
        this.repo = new RepositoryEmpleadosProcedimiento();
    }
    
    public String getEmpleados() {
        List<Emp> empleados = this.repo.getEmpleados();
        String html = "";
        for(Emp e: empleados) {
            html += "<tr>";
            html += "<td>" + e.getEmpNo() + "</td>";
            html += "<td>" + e.getApellido() + "</td>";
            html += "<td>" + e.getOficio()+ "</td>";
            html += "<td>" + e.getDir() + "</td>";
            html += "<td>" + e.getFechaAlt() + "</td>";
            html += "<td>" + e.getSalario()+ "</td>";
            html += "<td>" + e.getComision()+ "</td>";
            html += "<td>" + e.getDeptNo()+ "</td>";
            html += "</tr>";
        }
        return html;
    }
    
    public void updateSalarioEmpleados(int deptno, int incr) {
        this.repo.updateSalarioEmpleados(deptno, incr);
    }
}
