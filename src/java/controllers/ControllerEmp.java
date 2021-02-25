/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import repositories.RepositoryEmp;
import java.util.List;
import models.Emp;

/**
 *
 * @author lscar
 */
public class ControllerEmp {

    RepositoryEmp helper;
    
    public ControllerEmp(){
        this.helper = new RepositoryEmp();
    }
    
    public String getTablaEmp(){
        String html = "";
        List<Emp> z_empleados = this.helper.getEmpleados();
        for (Emp e : z_empleados){
            html += "<tr>";
            html += "<td>" + e.getEmpNo() + "</td>";
            html += "<td>" + e.getApellido() + "</td>";
            html += "<td>" + e.getOficio()+ "</td>";
            html += "</tr>";
        }
        return html;
    }
    
    public String getEmpleadosOficio(String oficio) {
        String html = "<ul>";
        List<Emp> z_empleados = this.helper.getEmpleadosOficio(oficio);
        for (Emp e : z_empleados){
            html += "<li>" + e.getApellido() + "</li>";
        }
        html += "</ul>";
        return html;
    }
}
