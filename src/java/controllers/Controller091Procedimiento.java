/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Doctor;
import repositories.Repository01Procedimiento;

/**
 *
 * @author lscar
 */
public class Controller091Procedimiento {
    
    Repository01Procedimiento repo;
    
    public Controller091Procedimiento() {
        this.repo = new Repository01Procedimiento();
    }
    
    public String getDoctores() {
        List<Doctor> doctores = this.repo.getDoctores();
        String html ="";
        for(Doctor d:doctores) {
            html += "<tr>";
            html += "<td>" + d.getDoctorNo() + "</td>";
            html += "<td>" + d.getHospitalCod() + "</td>";
            html += "<td>" + d.getApellido() + "</td>";
            html += "<td>" + d.getEspecialidad() + "</td>";
            html += "<td>" + d.getSalario()+ "</td>";
            html += "</tr>";
        }
        return html;
    }
    
    public void updateEspecialidadDoctor(int iddoc, String espe) {
        this.repo.updateEspecialidadDoctor(iddoc, espe);
    }
}











