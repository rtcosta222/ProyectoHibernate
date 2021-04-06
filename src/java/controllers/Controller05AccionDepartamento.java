/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Dept;
import repositories.RepositoryDepartamentos;

/**
 *
 * @author lscar
 */
public class Controller05AccionDepartamento {
    RepositoryDepartamentos repo;
    
    public Controller05AccionDepartamento() {
        this.repo = new RepositoryDepartamentos();
    }
    
    public String getTablaDepartamentos() {
        List<Dept> departamentos = this.repo.getDepartamentos();
        String html = "<tr>";
        for(Dept d: departamentos) {
            html += "<td>" + d.getDeptNo() + "</td>";
            html += "<td>" + d.getDnombre() + "</td>";
            html += "<td>" + d.getLoc() + "</td>";
            html +="</tr>";
        }
        return html;
    }
    
    public void insertarDepartamento(int num, String nom, String loc) {
        this.repo.insertarDepartamento(num, nom, loc);
    }
    
    public void eliminarDepartamento(int num){
        this.repo.eliminarDepartamento(num);
    }
    
    public void modificarDepartamento(int num, String nom, String loc){
        this.repo.modificarDepartamento(num, nom, loc);
    }
}
