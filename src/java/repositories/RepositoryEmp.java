/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import models.Emp;
import models.HibernateUtil;

/**
 *
 * @author lscar
 */
public class RepositoryEmp {
    Session session;
    
    public RepositoryEmp() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Emp> getEmpleados() {
        this.session.beginTransaction();
        String z_hql = "from Emp as emp";
        Query z_q = this.session.createQuery(z_hql);
        if (z_q.list().isEmpty()) {
            return null;
        } else { // El casting no es necesario 
//            return (List<Emp>)q.list();
            return z_q.list();
        }
    }

    public List<Emp> getEmpleadosOficio(String oficio) {
        this.session.beginTransaction();
        String z_hql = "from Emp as emp where upper(emp.oficio)=upper('" +
                oficio + "')";
        Query q = this.session.createQuery(z_hql);
        if (q.list().isEmpty()) {
            return null;
        } else {
            return (List<Emp>)q.list();
        }
    }
    
    public List<Emp> getEmpleadosDepartamento(int iddept) {
        this.session.beginTransaction();
        String z_hql = "from Emp as emp where emp.deptNo=" + iddept;
        Query query = this.session.createQuery(z_hql);
        if (query.list().isEmpty()) {
            return null;
        } else {
            return query.list();
        }
    }
}
