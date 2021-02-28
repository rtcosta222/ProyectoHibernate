/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Doctor;
import models.Hospital;
import repositories.RepositoryDoctores;
import repositories.RepositoryHospital;

/**
 *
 * @author lscar
 */
public class Controller04HospitalDoctores {
    RepositoryHospital repohosp;
    RepositoryDoctores repodoct;
    
    public Controller04HospitalDoctores() {
        this.repohosp = new RepositoryHospital();
        this.repodoct = new RepositoryDoctores();
    }
    
    public String getHospitales() {
        List<Hospital> hospitales = this.repohosp.getHospitales();
        String html = "<tr>";
        for(Hospital h: hospitales) {
            html += "<td>" + h.getHospitalCod() + "</td>";
            html += "<td>" + h.getNombre()+ "</td>";
            html += "<td>" + h.getDireccion() + "</td>";
            html += "<td>" + h.getTelefono() + "</td>";
            html += "<td>" + h.getNumCama() + "</td>";
            html += "<td><a href='web04hospitaldoctores2.jsp?idhosp=" + h.getHospitalCod() + "'>Ver doctores</a></td>";
            html +="</tr>";
        }
        return html;
    }
        public String getDoctoresHospital(int idhosp) {
        List<Doctor> doctores = this.repodoct.getDoctores(idhosp);
        String html = "<tr>";
        for(Doctor d: doctores) {
            html += "<td>" + d.getDoctorNo() + "</td>";
            html += "<td>" + d.getHospitalCod()+ "</td>";
            html += "<td>" + d.getApellido() + "</td>";
            html += "<td>" + d.getEspecialidad() + "</td>";
            html += "<td>" + d.getSalario() + "</td>";
            html += "<td></tr>";
        }
        return html;
    }
}
