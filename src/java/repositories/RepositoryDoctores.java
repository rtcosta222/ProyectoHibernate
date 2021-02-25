/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;
import models.Doctor;
import models.HibernateUtil;
import models.Hospital;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author lscar
 */
public class RepositoryDoctores {
    Session session;
    
    public RepositoryDoctores() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public List<Doctor> getDoctores(int idHosp) {
        this.session.beginTransaction();
        String z_hql = "from Doctor as doctor where hospitalCod=" + idHosp;
        Query query = this.session.createQuery(z_hql);
        chequear que los datos existen. Devolver null cuando no los hay.
        return query.list();
    }
}
