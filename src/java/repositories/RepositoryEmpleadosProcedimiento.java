/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Emp;
import models.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author lscar
 */
public class RepositoryEmpleadosProcedimiento {
    
    Session session;
    Transaction transaction;
    
    public RepositoryEmpleadosProcedimiento() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    private void initTransaccion() {
        if(this.session.isOpen() == false) {
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        }
        this.transaction = this.session.beginTransaction();
    }
    
    public List<Emp> getEmpleados() {
        this.initTransaccion();
        String z_hql = "from Emp as emp";
        Query query = this.session.createQuery(z_hql);
        List<Emp> empleados = query.list();
        this.session.close();
        return empleados;
    }
    
    public void updateSalarioEmpleados(int deptno, int incr) {
        this.initTransaccion();
        String z_hql = "call Pr_updatesalarioempleados(?,?)";
        Query query = this.session.createSQLQuery(z_hql);
        query.setParameter(0, deptno);
        query.setParameter(1, incr);
        query.executeUpdate();
        this.transaction.commit();
    }
}






