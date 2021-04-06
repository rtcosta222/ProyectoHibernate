/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Dept;
import org.hibernate.Session;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class RepositoryDepartamentos {
    Session session;
    // La transaccion debe ser unica al igual que la sesion.
    Transaction transaction;
    
    public RepositoryDepartamentos() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void iniciarTransaccion() {
        if(this.session.isOpen() == false) {
            // Session is closed. La volvemos a abrir:
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<Dept> getDepartamentos() {
        // Transaction
//        this.session.beginTransaction();
        this.iniciarTransaccion();
        // hql
        String z_hql = "from Dept as dept";
        // Ejecución
        Query query = this.session.createQuery(z_hql);
        // Return result
        if(query.list().isEmpty()) {
            return null;
        } else {
            return query.list();
        }
    }
    
    public void insertarDepartamento(int numero, String nombre, String localidad) {
        this.iniciarTransaccion();
        Dept dept = new Dept(numero, nombre, localidad);
        this.session.save(dept);
        this.transaction.commit();
    }
    
    public void eliminarDepartamento(int num) {
        this.iniciarTransaccion();
        Dept dept = (Dept)this.session.load(Dept.class, num);
        this.session.delete(dept);
        this.transaction.commit();
    }
       
    public void modificarDepartamento(int numero, String nombre, String localidad) {
        this.iniciarTransaccion();
        Dept dept = (Dept)this.session.load(Dept.class, numero);
        dept.setDnombre(nombre);
        dept.setLoc(localidad);
        this.session.update(dept);
        this.transaction.commit();
    }
}
