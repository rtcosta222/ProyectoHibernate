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
public class RepositoryProcedimiento {
    Session session;
    Transaction transaction;

    public RepositoryProcedimiento() {
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
        String z_hql = "from Doctor as doc";
        Query query = this.session.createQuery(z_hql);
        return query.list();
    } 
    
    public void modificarEspecialidadDoctor(int iddoctor, String especialidad) {
        this.initTransaccion();
        String z_sql = "call pr_updateespecialidaddoctor(?,?)";
        Query query = this.session.createSQLQuery(z_sql);
        query.setParameter(0, iddoctor);
        query.setParameter(1, especialidad);
        query.executeUpdate();
        this.transaction.commit();
    }
}
