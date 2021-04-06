/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Resumen;
import repositories.RepositoryConsultasEspeciales;

/**
 *
 * @author lscar
 */
public class Controller11ConsultasEspeciales {
    RepositoryConsultasEspeciales repo;
    
    public Controller11ConsultasEspeciales(){
        this.repo = new RepositoryConsultasEspeciales();
    }
    
    public String getResumen(int deptno){
        Resumen resumen = this.repo.getResumen(deptno);
        String html = "";
        if(resumen != null){
            html += "<h4 style='color:blue'>Personas: " + resumen.getNumpersonas() + "</h4>";
            html += "<h4 style='color:red'>Max. salario: " + resumen.getMaxsalario() + "</h4>";
            html += "<h4 style='color:green'>Min salario: " + resumen.getMinsalario() + "</h4>";
        } else{
            html += "<h3 style='color:red'>No existe el dept " + deptno + "</h3>";
        }
        return html;
    }
} 
