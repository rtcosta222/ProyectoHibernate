/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Dept;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class Repository01Departamentos {

    Session session;
    Transaction transaction;

    public Repository01Departamentos() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void initTransaccion() {
        if(this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<Dept> getTablaDepartamentos() {
        this.initTransaccion();
        String z_hql = "from Dept as dept";
        Query query = this.session.createQuery(z_hql);
        if(query.list().isEmpty()) {
            return null;
        } else {
            return query.list();
        }
    }
    
    public void insertarDepartamento(int dnum, String dnom, String dloc) {
        this.initTransaccion();
        Dept dept = new Dept(dnum, dnom, dloc);
        this.session.save(dept);
        this.transaction.commit();
    }
    
    public void modificarDepartamento(int dnum, String dnom, String dloc) {
        this.initTransaccion();
        Dept dept = (Dept) this.session.load(Dept.class, dnum);
        dept.setDnombre(dnom);
        dept.setLoc(dloc);
        this.session.update(dept);
        this.transaction.commit();
    }
    
    public void eliminarDepartamento(int dnum) {
        this.initTransaccion();
        Dept dept = (Dept) this.session.load(Dept.class, dnum);
        this.session.delete(dept);
        this.transaction.commit();
    }
}
