/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Doctor;
import repositories.RepositoryDoctores;

/**
 *
 * @author lscar
 */
public class Controller06AccionDoctor {
    
    RepositoryDoctores repo;
    
    public Controller06AccionDoctor() {
        this.repo = new RepositoryDoctores();
    }
    
    public String getTablaDoctor() {
        List<Doctor> doctores = this.repo.getTablaDoctor();
        String html = "";
        for(Doctor d:doctores) {
            html += "<tr>";
            html += "<td>" + d.getHospitalCod()+ "</td>";
            html += "<td>" + d.getDoctorNo()+ "</td>";
            html += "<td>" + d.getApellido() + "</td>";
            html += "<td>" + d.getEspecialidad() + "</td>";
            html += "<td>" + d.getSalario() + "</td>";
            html += "<td><a href='web06acciondoctor.jsp?delete=" + d.getDoctorNo()  + "'>Eliminar</a></td>";
            html += "<td><button type='button'>";
            html += "<a href='web06acciondoctor.jsp?delete=" + d.getDoctorNo()  + "'>Eliminar</a></button></td>";
            html += "</tr>";
        }
        return html;
    }
    
    public void insertarDoctor(int hcod, int docno, String ape, String esp, int sal) { 
        this.repo.insertarDoctor(hcod, docno, ape, esp, sal);
    }
    
    public void modificarDoctor(int hcod, int docno, String ape, String esp, int sal) {
        this.repo.modificarDoctor(hcod, docno, ape, esp, sal);
    }
    
    public void eliminarDoctor(int docno) {
        this.repo.eliminarDoctor(docno);
    }
}
