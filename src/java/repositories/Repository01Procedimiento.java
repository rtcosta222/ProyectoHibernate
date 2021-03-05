/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Doctor;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class Repository01Procedimiento {
    
    Session session;
    Transaction transaction;
    
    public Repository01Procedimiento() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void initTransaccion() {
        if(this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<Doctor> getDoctores() {
        this.initTransaccion();
        String z_hql = "from Doctor as doctor";
        Query query = this.session.createQuery(z_hql);
        List<Doctor> doctores = query.list();
        this.session.close();
        return doctores;
    }
    
    public void updateEspecialidadDoctor(int iddoc, String espe) {
        this.initTransaccion();
        String z_hql = "call pr_updateespecialidaddoctor01(?,?)";
        Query query = this.session.createSQLQuery(z_hql);
        query.setParameter(0, iddoc);
        query.setParameter(1, espe);
        query.executeUpdate();
        this.transaction.commit();
    }
}


















