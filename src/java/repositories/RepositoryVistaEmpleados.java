/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.ArrayList;
import java.util.List;
import models.HibernateUtil;
import models.Vistaempleados;
import models.VistaempleadosId;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class RepositoryVistaEmpleados {
    Session session;
    Transaction transaction;
    
    public RepositoryVistaEmpleados() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void iniciarTransaccion() {
        if(this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<VistaempleadosId> getVistaEmpleados() {
        this.iniciarTransaccion();
        String z_hql = "from Vistaempleados as vista";
        Query query = this.session.createQuery(z_hql);
        List<Vistaempleados> list = query.list();
        ArrayList<VistaempleadosId> empleados = new ArrayList<>();
        for(Vistaempleados e: list) {
            VistaempleadosId emp = e.getId();
            empleados.add(emp);
        }
        return empleados;
    }
    
    public List<VistaempleadosId> getVistaEmpleadosLocalidad(String loc) {
        this.iniciarTransaccion();
        String z_hql = "from Vistaempleados as vista where lower(vista.id.localidad)='" 
                        + loc.toLowerCase() + "'";
        Query query = this.session.createQuery(z_hql);
        List<Vistaempleados> list = query.list();
        ArrayList<VistaempleadosId> empleados = new ArrayList<>();
        for(Vistaempleados e: list) {
            VistaempleadosId emp = e.getId();
            empleados.add(emp);
        }
        return empleados;   
    }
}
