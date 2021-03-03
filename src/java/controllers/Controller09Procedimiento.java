/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Doctor;
import repositories.RepositoryProcedimiento;


/**
 *
 * @author lscar
 */
public class Controller09Procedimiento {
    RepositoryProcedimiento repo;
    
    public Controller09Procedimiento() {
        this.repo = new RepositoryProcedimiento();
    }
    
    public String getTablaDoctores() {
        List<Doctor> doctores = this.repo.getDoctores();
        String html = "";
        for(Doctor d: doctores) {
            html += "<tr>";
            html += "<td>" + d.getDoctorNo() + "</td>";
            html += "<td>" + d.getApellido() + "</td>";
            html += "<td>" + d.getEspecialidad() + "</td>";
            html += "</tr>";
        }
        return html;
    }
    
    public void modificarEspecialidadDoctor(int iddoctor, String especialidad) {
        this.repo.modificarEspecialidadDoctor(iddoctor, especialidad);
    }
}
