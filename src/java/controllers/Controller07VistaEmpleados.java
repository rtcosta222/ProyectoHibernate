/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.VistaempleadosId;
import repositories.RepositoryVistaEmpleados;

/**
 *
 * @author lscar
 */
public class Controller07VistaEmpleados {
    RepositoryVistaEmpleados repo;
    
    public Controller07VistaEmpleados() {
        this.repo = new RepositoryVistaEmpleados();
    }
    
    public String getTablaVistaEmpleados() {
        List<VistaempleadosId> empleados = repo.getVistaEmpleados();
        String html = "";
        for(VistaempleadosId e: empleados) {
            html += "<tr>";
            html += "<td>" + e.getApellido() + "</td>";
            html += "<td>" + e.getOficio() + "</td>";
            html += "<td>" + e.getDepartamento() + "</td>";
            html += "<td>" + e.getFechaalta() + "</td>";
            html += "<td>" + e.getLocalidad() + "</td>";
            html += "<td>" + e.getAnual()+ "</td>";
            html += "</tr>";
        }
        return html;
    }
    
    public String getTablaEmpleadosLocalidad(String loc) {
        List<VistaempleadosId> empleados = repo.getVistaEmpleadosLocalidad(loc);
        if (empleados == null) {
            return "<h1 style='color:red'>No hay empleados en " + loc + "</h1>";
        }
        String html = "";
        for(VistaempleadosId e: empleados) {
            html += "<tr>";
            html += "<td>" + e.getApellido() + "</td>";
            html += "<td>" + e.getOficio() + "</td>";
            html += "<td>" + e.getDepartamento() + "</td>";
            html += "<td>" + e.getFechaalta() + "</td>";
            html += "<td>" + e.getLocalidad() + "</td>";
            html += "<td>" + e.getAnual()+ "</td>";
            html += "</tr>";
        }
        return html;
    }
}
