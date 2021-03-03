/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import models.Dept;
import repositories.Repository01Departamentos;

/**
 *
 * @author lscar
 */
public class Controller051AccionDepartamento {
    Repository01Departamentos repo;
    
    public Controller051AccionDepartamento() {
        this.repo = new Repository01Departamentos();
    }
    
    public String getTablaDepartamentos() {
        List<Dept> depts = this.repo.getTablaDepartamentos();
        String html = "";
        for(Dept d: depts) {
            html += "<tr>";
            html += "<td>" + d.getDeptNo() + "</td>";
            html += "<td>" + d.getDnombre() + "</td>";
            html += "<td>" + d.getLoc() + "</td>";
            html += "<td><a href='web051acciondepartamento.jsp?eliminar=" + d.getDeptNo() + "'>Eliminar</a></td>";
            html += "</tr>";
        }
        return html;
    }
    
    public void insertarDepartamento(int dnum, String dnom, String dloc) {
        this.repo.insertarDepartamento(dnum, dnom, dloc);
    }
    
    public void modificarDepartamento(int dnum, String dnom, String dloc) {
        this.repo.modificarDepartamento(dnum, dnom, dloc);
    }
    
    public void eliminarDepartamento(int dnum) {
        this.repo.eliminarDepartamento(dnum);
    }
}
