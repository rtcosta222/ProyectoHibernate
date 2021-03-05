/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.VistaplantillaId;
import repositories.RepositoryVistaPlantilla;

/**
 *
 * @author lscar
 */
public class Controller08VistaPlantilla {
    RepositoryVistaPlantilla repo;
    
    public Controller08VistaPlantilla() {
        this.repo = new RepositoryVistaPlantilla();
    }
    
    public String getVistaPlantillaHospitales() {
        List<VistaplantillaId> plantilla = this.repo.getVistaPlantillaHospitales();
        String html = "";
        for(VistaplantillaId v: plantilla) {
            html += "<tr>";
            html += "<td>" + v.getApellido() + "</td>";
            html += "<td>" + v.getFuncion() + "</td>";
            html += "<td>" + v.getSalario() + "</td>";
            html += "<td>" + v.getNombre() + "</td>";
            html += "<td>" + v.getTelefono() + "</td>";
            html += "</tr>";
        }
        return html;
    }

    public String getVistaPlantillaHospital(String hnom) {
        List<VistaplantillaId> plantilla = this.repo.getVistaPlantillaHospital(hnom);
        String html = "";
        for(VistaplantillaId v: plantilla) {
            html += "<tr>";
            html += "<td>" + v.getApellido() + "</td>";
            html += "<td>" + v.getFuncion() + "</td>";
            html += "<td>" + v.getSalario() + "</td>";
            html += "<td>" + v.getNombre() + "</td>";
            html += "<td>" + v.getTelefono() + "</td>";
            html += "</tr>";
        }
        return html;
    }
}
