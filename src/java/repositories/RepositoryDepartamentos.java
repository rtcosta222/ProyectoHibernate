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

/**
 *
 * @author lscar
 */
public class RepositoryDepartamentos {
    Session session;
    
    public RepositoryDepartamentos() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Dept> getDepartamentos() {
        this.session.beginTransaction();
        String z_hql = "from Dept as dept";
        Query query = this.session.createQuery(z_hql);
        return query.list();
    }
}
