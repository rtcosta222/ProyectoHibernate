/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Dept;
import models.Emp;
import repositories.RepositoryDepartamentos;
import repositories.RepositoryEmp;

/**
 *
 * @author lscar
 */
public class Controller03EmpleadosDepartamento {
    RepositoryDepartamentos repodept;
    RepositoryEmp repoemp;
    
    public Controller03EmpleadosDepartamento() {
        this.repodept = new RepositoryDepartamentos();
        this.repoemp = new RepositoryEmp();
    }
    
    public String getOptionsDepartamentos() {
        List<Dept> departamentos = this.repodept.getDepartamentos();
        String html = "";
        for(Dept d: departamentos) {
            html += "<option value='" + d.getDeptNo() + "'>"
                    + d.getDnombre() + "</option>";
        }
        return html;
    }
    
    public String getEmpleadosDepartamento(int id) {
        List<Emp> empleados = this.repoemp.getEmpleadosDepartamento(id);
        String html = "";
        if(empleados != null) {
            html += "<ul>";
            for(Emp e: empleados) {
                html += "<li>" + e.getApellido() + ", " + e.getOficio() + ", " + e.getEmpNo() + "</li>";
            }
            html += "</ul>";
        } else {
            html += "<h2 style='color:red'> No hay empleados asignados al departamento " + id + "</h2>";
        }
        return html;
    }
}
