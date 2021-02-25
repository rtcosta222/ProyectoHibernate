/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Dept;
import models.HibernateUtil;
import models.Hospital;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author lscar
 */
public class RepositoryHospital {
    
    Session session;
    
    public RepositoryHospital() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Hospital> getHospitales() {
        this.session.beginTransaction();
        String z_hql = "from Hospital as hospital";
        Query query = this.session.createQuery(z_hql);
        return query.list();
    }
}
